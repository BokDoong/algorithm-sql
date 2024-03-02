package BaekJoon_Study.bfs;

import java.util.Scanner;

public class test_16946_my {

    static int N, M, cnt;
    static boolean[][] visited;
    static int[][] board, result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();

        sc.nextLine();
        board = new int[N][M]; result = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        //main
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    cnt = 1;
                    visited = new boolean[N][M];
                    dfs(i, j);
                    result[i][j] = cnt;
                }
            }
        }

        //output
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * dfs - 시간초과
     * main 에서 board 반복문 돌리면서 - visited초기화 + dfs
     * cnt 받아서 결과배열에 저장?
     */
    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;
            if (!visited[nx][ny] && board[nx][ny] == 0) {
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny);
            }
        }
    }
}
