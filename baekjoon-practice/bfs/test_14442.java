package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_14442 {

    static class Node {
        int x;
        int y;
        int cnt;
        int breakWall;

        public Node(int x, int y, int cnt, int breakWall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakWall = breakWall;
        }
    }

    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();

        map = new int[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        //main
        //visited[N][M][k] : k번 부순 배열
        visited = new boolean[N][M][K+1];

        //output
        System.out.println(bfs(new Node(0, 0, 1, 0)));
    }

    static int bfs(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            //목표점 도달
            if (now.x == N - 1 && now.y == M - 1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                //범위 체크
                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                //빈 공간일 때
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][now.breakWall]) {
                        queue.add(new Node(nx, ny, now.cnt + 1, now.breakWall));
                        visited[nx][ny][now.breakWall] = true;
                    }
                }
                //벽일 때
                else {
                    //k+1번 부순지 체크하는 배열 이용
                    if (now.breakWall < K && !visited[nx][ny][now.breakWall+1]) {
                        queue.add(new Node(nx, ny, now.cnt + 1, now.breakWall + 1));
                        visited[nx][ny][now.breakWall+1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
