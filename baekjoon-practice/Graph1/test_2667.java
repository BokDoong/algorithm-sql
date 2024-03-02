package BaekJoon_Study.Graph1;

import java.util.Arrays;
import java.util.Scanner;

public class test_2667 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int [] apart = new int[25*25];

    static int[][] graphs;
    static boolean[][] visited;
    static int N;
    static int ApartNum = 0;


    static void dfs(int x, int y) {

        visited[x][y] = true;
        apart[ApartNum]++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(graphs[nx][ny] == 1 && !visited[nx][ny])
                    dfs(nx,ny);
            }
        }

    }

    public static void main(String[] args) {

        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        graphs = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String input = sc.nextLine();
            for(int j=0; j<N; j++) {
                graphs[i][j] = input.charAt(j) - '0';
            }
        }

        //main
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graphs[i][j] == 1 && !visited[i][j]){
                    ApartNum++;
                    dfs(i,j);
                }
            }
        }

        //output
        Arrays.sort(apart);
        System.out.println(ApartNum);
        for (int i = 0; i < apart.length; i++) {
            if (apart[i] == 0) {
            }
            else {
                System.out.println(apart[i]);
            }
        }
    }
}

