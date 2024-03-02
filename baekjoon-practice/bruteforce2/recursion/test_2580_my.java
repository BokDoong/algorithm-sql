package BaekJoon_Study.bruteforce2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_2580_my {
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
            fillBlank(x, y);
            dfs(x, y + 1);

            //스도쿠가 잘못됨
            board[x][y] = 0;
            return;
        }
        //빈칸(0)이 아닐 때
        dfs(x, y + 1);
    }

    static void fillBlank(int x, int y) {
        boolean[] nums = new boolean[10];
        nums[0] = true;

        //같은 열(세로), 행(가로)
        for (int i = 0; i < 9; i++) {
            nums[board[i][y]] = true;
            nums[board[x][i]] = true;
        }
        //3x3 안에서 -> [0~2][0~2], [3~5][3~5], [6~8][6~8]
        //board[1][5] -> board[0~2][3~5]에 속함
        int start_x = (x/3)*3; int start_y = (y/3)*3;
        for (int i = start_x; i < start_x + 3; i++) {
            for (int j = start_y; j < start_y + 3; j++) {
                nums[board[i][j]] = true;
            }
        }

        for (int i = 0; i < 10; i++) {
            if(!nums[i])
                board[x][y] = i;
        }
    }
}
