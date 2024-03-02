package BaekJoon_Study.Graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_2178 {

    static int n,m;
    static boolean[][] visited;
    static int[][] graphs;
    static int[] dh = {0, 0, 1, -1};
    static int[] dw = {1, -1, 0, 0};
    static int result = Integer.MAX_VALUE;

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    static void bfs(int h, int w){

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(h, w));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nh = node.x + dh[i];
                int nw = node.y + dw[i];

                //범위 초과
                if(nh>n || nw>m || nh<=0 || nw<=0)
                    continue;

                //방문한 경우 + 길이 아닌경우
                if(visited[nh][nw] == true || graphs[nh][nw]==0)
                    continue;

                visited[nh][nw] = true;
                graphs[nh][nw] = graphs[node.x][node.y] + 1;
                queue.add(new Node(nh,nw));
            }
        }
    }

    public static void main(String[] args) {

        //input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graphs = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String input = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                graphs[i][j] = input.charAt(j-1) - '0';
            }
        }

        //main
        visited[1][1] = true;
        bfs(1,1);
        System.out.println(graphs[n][m]);

    }
}
