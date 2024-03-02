package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_1987 {

    static char[][] board;
    static boolean[] visited;
    static int R, C;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        //input - R 열(세로), C 행(가로)
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        sc.nextLine();
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        //main
        visited = new boolean[26];
        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        //output
        System.out.println(max);
    }

    static void dfs(int x, int y, int now) {
        max = Math.max(max, now);

        for (int i = 0; i < 4; i++) {
            //상하좌우 이동
            int nx = x + dx[i];
            int ny = y + dy[i];
            //이동 칸 범위 체크
            if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                continue;
            //이동 칸의 알파벳 방문여부 체크
            if (visited[board[nx][ny] - 'A'])
                continue;

            //방문 안헀으면 진행
            visited[board[nx][ny]-'A'] = true;
            dfs(nx, ny, now + 1);
            visited[board[nx][ny]-'A'] = false;
        }
    }
}
