package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class test_16933_my {

    static int N, M , K;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node{
        int x, y, cnt, breakWall;
        boolean time;

        //time: true-낮, false-밤
        public Node(int x, int y, int cnt, int breakWall, boolean time) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakWall = breakWall;
            this.time = time;
        }
    }

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

        //output
        System.out.println(bfs(new Node(0, 0, 1, 0, true)));
    }

    static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        boolean[][][] visited = new boolean[N][M][K + 1];
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int prevX = now.x;
            int prevY = now.y;
            int breakWall = now.breakWall;
            int cnt = now.cnt;
            boolean time = now.time;
            boolean reverse = !time;

            if (now.x == N - 1 && now.y == M - 1)
                return cnt;

            for (int i = 0; i < 4; i++) {
                int nextX = prevX + dx[i];
                int nextY = prevY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                //벽o
                if (map[nextX][nextY] == 1) {
                    //밤이면 - 벽을 부술 수 있으면 가만히있기
                    //방문처리 x - 낮으로 돌아가서 그때 처리해야 정확히 나옴(이동하는 것은 낮이기 때문)
                    if (now.breakWall < K && now.time == false) {
                        queue.add(new Node(prevX, prevY, cnt + 1, breakWall, reverse));
                    }
                    //낮이면 - 벽 부술수 있고 다음꺼 방문 안되어있으면 부수기
                    if (now.breakWall < K && now.time == true && !visited[nextX][nextY][now.breakWall+1]) {
                        visited[nextX][nextY][now.breakWall+1] = true;
                        queue.add(new Node(nextX, nextY, cnt + 1, breakWall + 1, reverse));
                    }
                }
                //벽x - 그냥 가면됨
                else {
                    //만약 방문 안했으면
                    if (!visited[nextX][nextY][breakWall]) {
                        visited[nextX][nextY][now.breakWall] = true;
                        queue.add(new Node(nextX, nextY, cnt+1, breakWall, reverse));
                    }
                }
            }
        }

        return -1;
    }
}


