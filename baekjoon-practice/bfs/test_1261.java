package BaekJoon_Study.bfs;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class test_1261 {

    static int N, M;
    static int[][] path;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static int bfs() {

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 1, 0));
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == M && now.y == N) {
                return now.wall;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx > M || ny < 0 || ny > N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                if (path[nx][ny] == 1) {
                    queue.add(new Node(nx, ny, now.wall + 1));
                } else {
                    queue.add(new Node(nx, ny, now.wall));
                }
                visited[nx][ny] = true;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        path = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            String[] input = sc.nextLine().split("");
            for (int j = 1; j <= N; j++) {
                path[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        //output
        System.out.println(bfs());
    }

    public static class Node implements Comparable<Node>{

        int x;
        int y;
        int wall;

        public Node(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
        @Override
        public int compareTo(Node a){
            return this.wall - a.wall;
        }
    }
}
