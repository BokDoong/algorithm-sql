package BaekJoon_Study.bfs;

import java.util.Scanner;

public class test_my_14502 {

    static int N, M;
    static boolean[][] visited;
    static int[][] board;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int pos = sc.nextInt();
                if(pos == 1 || pos == 2)
                    visited[i][j] = true;

                board[i][j] = pos;
            }
        }

        //main
        dfs(0);

        //output
        System.out.println(result);
    }

    static void dfs(int wall) {
        if (wall == 3) {
            result = Math.max(result, countInfection());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j])
                    continue;

                visited[i][j] = true;
                board[i][j] = 1;
                dfs(wall + 1);
                board[i][j] = 0;
                visited[i][j] = false;
            }
        }

    }

    static int countInfection() {
        int cnt = 0;
        int[][] testBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                testBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-1; j++) {
                if (testBoard[i][j] == 2) {
                    if(testBoard[i+1][j] != 2)
                        testBoard[i+1][j] = 2;
                    if(testBoard[i][j+1] != 2)
                        testBoard[i][j+1] = 2;
                }
            }
        }

        return getCnt(cnt, testBoard);
    }

    private static int getCnt(int cnt, int[][] testBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(testBoard[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
