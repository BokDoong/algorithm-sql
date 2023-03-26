package BaekJoon_Study.bruteforce2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_2580 {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 9 ; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0 ; str.hasMoreTokens();j++) {
                board[i][j]= Integer.parseInt(str.nextToken());
            }
        }

        //main
        dfs(0, 0);
    }

    /**
     * 1) 3x3 칸 안에서 1~9로 구성되어야함.
     * 2) 전체 가로,세로 9칸은 1~9로 구성
     * 과정) 0 은 빈칸, 위의 두가지 조건 만족해야함 -> dfs 돌려서 0 나오면 함수로 수 채워넣기, 9이면 다음 행 or 열로 dfs
     * 매개변수) x-세로, y-가로, depth 9개 다 체크했는지?
     */
    static void dfs(int x, int y) {
        //행 좌표가 9일 때 -> 다음 열
        if (y == 9) {
            dfs(x+1, 0);
            return;
        }

        //열 좌표가 9일 때 -> 끝
        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        //0 일 때
        if (board[x][y] == 0) {
            for(int i = 1 ; i <= 9 ; i++) {
                if(fillBlank(x, y, i)) {
                    board[x][y] = i;
                    dfs(x, y+1);
                }
            }

            //스도쿠가 잘못됨
            board[x][y] = 0;
            return;
        }
        //빈칸(0)이 아닐 때
        dfs(x, y + 1);
    }

    static boolean fillBlank(int x, int y, int value) {

        //같은열에 무슨 숫자가 비었는지
        for(int i = 0 ; i < 9 ; i ++) {
            if(board[x][i] == value) {
                return false;
            }
        }

        //같은행에 무슨 숫자가 비었는지
        for(int i = 0 ; i < 9 ; i ++) {
            if(board[i][y] == value) {
                return false;
            }
        }

        //같은 네모에 뭐가 있는지
        int ind_row = (x/3)*3;
        int ind_col = (y/3)*3;

        for(int i = ind_row ; i < ind_row+3 ; i ++) {
            for(int j = ind_col ; j < ind_col +3 ; j++) {
                if(board[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}
