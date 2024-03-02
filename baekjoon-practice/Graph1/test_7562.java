package BaekJoon_Study.Graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_7562 {

    static int line;
    static int[][] chess;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<Node>();
    static int[] dx = {2,1,-1,-2,-2,-1,1,2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {

        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            int now_x = node.x;
            int now_y = node.y;

            for (int i = 0; i < 8; i++) {
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];

                //범위
                if(nx < 0 || ny < 0 || nx >= line || ny >= line)
                    continue;

                //방문여부
                if(visited[nx][ny] == false){
                    chess[nx][ny] = chess[now_x][now_y]+1;
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) {

        //input
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        //main
        while (t > 0) {
            //체스판
            line = sc.nextInt();
            chess = new int[line][line];
            visited = new boolean[line][line];
            //현재위치
            int x = sc.nextInt(); int y = sc.nextInt();
            //bfs
            bfs(x, y);
            //target
            int resx = sc.nextInt();
            int resy = sc.nextInt();
            System.out.println(chess[resx][resy]);

            t--;
        }

    }
}
