package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_4574 {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            if (N == 0)
                System.exit(0);

            sc.nextLine();
            board = new int[9][9];
            for (int i = 0; i < N; i++) {
                String[] input = sc.nextLine().split(" ");
                board[input[1].charAt(0) - 'A'][input[1].charAt(1) - '1'] = Integer.parseInt(input[0]);
                board[input[3].charAt(0) - 'A'][input[3].charAt(1) - '1'] = Integer.parseInt(input[2]);
            }

            String[] input2 = sc.nextLine().split(" ");
            for (int i = 1; i <= 9; i++) {
                board[input2[i-1].charAt(0) - 'A'][input2[i-1].charAt(1) - '1'] = i;
            }

            //main
            visited = new boolean[10][10];
            dfs(1, 2);
        }
    }

    static void dfs(int x, int y) {
        //행 좌표가 9일 때 -> 다음 열
        if (y == 9) {
            dfs(x + 1, 0);
        }

        //열 좌표가 9일 때 -> 끝
        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        //보드가 0일 때 -> 1.visited[x][y] 체크 2.좌우상하 0 찾아서 fillBlank
        if (board[x][y] == 0) {
            for (int k = 0; k < 4; k++) {
                //상하좌우 체크
                int nx = x + dx[k]; int ny = y + dy[k];
                if(nx<0 || nx>8 || ny<0 || ny>8)
                    continue;
                if (board[nx][ny] == 0) {
                    //들어갈 쌍 조건
                    for (int i = 1; i < 9; i++) {
                        for (int j = i + 1; j < 10; j++) {
                            if(visited[i][j])
                                continue;
                            if (fillBlank(x, y, nx, ny, i, j)) {
                                visited[i][j] = true;
                                board[x][y] = i; board[nx][ny] = j;
                                dfs(x, y + 1);
                                visited[i][j] = false;
                            }

                            if(visited[j][i])
                                continue;
                            if (fillBlank(x, y, nx, ny, j, i)) {
                                visited[j][i] = true;
                                board[x][y] = j; board[nx][ny] = i;
                                dfs(x, y + 1);
                                visited[j][i] = false;
                            }
                        }
                    }
                }
            }
        }

        //빈칸 아니면 넘어가기
        dfs(x + 1, y);
    }

    static boolean fillBlank(int x1, int y1, int x2, int y2, int value1, int value2) {

        //같은열에 무슨 숫자가 비었는지
        for(int i = 0 ; i < 9 ; i ++) {
            if(board[x1][i] == value1 || board[x2][i] == value2) {
                return false;
            }
        }

        //같은행에 무슨 숫자가 비었는지
        for(int i = 0 ; i < 9 ; i ++) {
            if(board[i][y1] == value1 || board[i][y2] == value2) {
                return false;
            }
        }

        //같은 네모에 뭐가 있는지
        int ind_row1 = (x1/3)*3; int ind_col1 = (y1/3)*3;
        int ind_row2 = (x2/3)*3; int ind_col2 = (y2/3)*3;
        //(x1, y1)
        for(int i = ind_row1 ; i < ind_row1+3 ; i ++) {
            for(int j = ind_col1 ; j < ind_col1 +3 ; j++) {
                if(board[i][j] == value1)
                    return false;
            }
        }
        //(x2, y2)
        for(int i = ind_row2 ; i < ind_row2+3 ; i ++) {
            for(int j = ind_col2 ; j < ind_col2+3 ; j++) {
                if(board[i][j] == value2)
                    return false;
            }
        }

        return true;
    }
}
