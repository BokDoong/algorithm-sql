package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_16948 {

    static int N;
    static int targetR, targetC;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int[][] visited;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        targetR = sc.nextInt();
        targetC = sc.nextInt();

        //main
        visited = new int[N][N];
        visited[r][c] = 1;

        //output
        System.out.print(bfs(new Node(r, c, 0)));
    }

    static int bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == targetR && now.y == targetC) {
                return now.cnt;
            }

            for (int i = 0; i < 6; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                    continue;

                if (visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = now.cnt+1;
                    queue.add(new Node(nextX, nextY, now.cnt + 1));
                }
            }
        }

        return -1;
    }

    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
