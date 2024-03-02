package BaekJoon_Study.Graph1;

import java.util.Scanner;

public class test_4963 {

    static int w, h;
    static int island;
    static int[][] graphs;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1,1,-1,-1,1};
    static int[] dy = {1,-1,0,0,1,1,-1,-1};


    static void dfs(int x, int y){

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                if(graphs[nx][ny]==1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }

    }

    public static void main(String[] args){
        //input
        Scanner sc = new Scanner(System.in);
        while(true){

            w = sc.nextInt();
            h = sc.nextInt();
            if(w==0 && h==0)
                break;

            island = 0;
            graphs = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    graphs[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<h; i++) {
                for (int j = 0; j < w; j++) {
                    if(graphs[i][j]==1 && !visited[i][j]){
                        island++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(island);
        }
    }
}
