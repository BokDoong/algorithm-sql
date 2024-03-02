package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_3085 {

    static char[][] board;
    static int N;
    static int max = 0;


    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        //main
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //위아래 변경
                if (i + 1 < N) {
                    swap1(i, j);
                    check();
                    swap1(i, j);
                }

                //오른쪽 변경
                if (j + 1 < N) {
                    swap2(i, j);
                    check();
                    swap2(i, j);
                }
            }
        }

        //output
        System.out.println(max);
    }

    //행열 중복체크
    static void check() {
        //가로
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }

        //세로
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cnt++;
                    max = Math.max(cnt, max);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    //위-아래 교환
    static void swap1(int x, int y) {
        char tmp = board[x][y];
        board[x][y] = board[x+1][y];
        board[x+1][y] = tmp;
    }

    //양-옆 교환
    static void swap2(int x, int y) {
        char tmp = board[x][y];
        board[x][y] = board[x][y+1];
        board[x][y+1] = tmp;
    }
}
