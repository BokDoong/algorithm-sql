package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 최종적으로 부수지 않고 간 경우가 더 빠를 수 있다는 반례가 존재하기 때문에 일반적인 이중배열 visit 처리로는 풀이가 불가했다. 아래 반례를 실행해보면 이해할 수 있다.
 */
public class test_2206_my {

    static int N, M;
    static int[][] board, visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        sc.nextLine();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        //main
        visited = new int[N][M];

        //output
        System.out.println(bfs(new Node(0, 0, 0)));
    }

    static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int wall = now.breakWall;

            if(x==N-1 && y==M-1)
                return visited[N - 1][M - 1]+1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (board[nx][ny] == 0) {
                    if (visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[x][y] + 1;
                        queue.add(new Node(nx, ny, wall));
                    }
                } else {
                    if (visited[nx][ny] == 0 && wall == 0) {
                        visited[nx][ny] = visited[x][y] + 1;
                        queue.add(new Node(nx, ny, wall+1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int breakWall;

        public Node(int x, int y, int breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }
    }
}
