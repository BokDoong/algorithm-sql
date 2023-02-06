package BaekJoon_Study.BruteForce.Recursion;

import java.util.Scanner;

public class test_14391 {
    //가로,세로
    static int N;
    static int M;
    //종이
    static int[][] paper;
    static boolean[][] visited;
    static int result = 0;

    static void dfs(int row, int col) {
        if (row >= N) {
            sum();
            return;
        }
        if (col >= M) {
            dfs(row + 1, 0);
            return;
        }

        //해당좌표 선택
        visited[row][col] = true;
        dfs(row, col+1);
        visited[row][col] = false;

        //해당좌표 미선택
        dfs(row, col + 1);
    }

    static void sum(){
        int sum = 0;
        //가로
        for (int i = 0; i < N; i++) {
            int tsum = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == true) {
                    tsum = tsum*10;
                    tsum += paper[i][j];
                }
                else{
                    sum += tsum;
                    tsum = 0;
                }
            }
            sum+=tsum; // 한 행 계산 결과 저장
        }

        //세로
        for (int i = 0; i < M; i++) {
            int tsum = 0;
            for (int j = 0; j < N; j++) {
                if (visited[j][i] == false) {
                    tsum *= 10;
                    tsum += paper[j][i];
                }
                else{
                    sum += tsum;
                    tsum = 0;
                }
            }
            sum += tsum;
        }
        result = Math.max(result, sum);
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        paper = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }

        //main
        dfs(0, 0);

        //output
        System.out.println(result);
    }
}
