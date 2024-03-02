package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_14500 {

    static int N, M;
    static int answer = Integer.MIN_VALUE;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로
        M = sc.nextInt();   //가로

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        //main
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1, board[i][j], i, j);
                visited[i][j] = false;
            }
        }

        //output
        System.out.println(answer);
    }

    //depth 4가 되면 return
    static void dfs(int depth, int sum, int x, int y) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(visited[nx][ny])
                    continue;

                // ㅗ모양
                if (depth == 2) {
                    visited[nx][ny] = true;
                    dfs(depth + 1, sum + board[nx][ny], x, y);
                    visited[nx][ny] = false;
                }

                //나머지
                visited[nx][ny] = true;
                dfs(depth + 1, sum + board[nx][ny], nx, ny);
                visited[nx][ny] = false;
            }
        }

    }

}
