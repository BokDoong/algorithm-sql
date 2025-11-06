import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] board;
    static long[][][] dp;
    static long result;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        board = new int[N+1][N+1];
        dp = new long[N+1][N+1][3];
        for ( int i = 1 ; i < N+1 ; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 1 ; j < N+1 ; j++ ) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
    }

    // 0(우), 1(하), 2(우하)
    static void solve() {

        if ( board[N][N] == 1 ) {
            return;
        }

        dp[1][2][0] = 1;

        for ( int i = 1 ; i < N+1 ; i++ ) {
            for ( int j = 3 ; j < N+1 ; j++ ) {

                // 벽이면 통과
                if ( board[i][j] == 1 ) {
                    continue;
                }

                // 가로
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];

                // 첫 줄이면 세로, 대각선 볼 필요 없음
                if ( i == 1 ) {
                    continue;
                }

                // 세로
                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];

                // 좌, 상이 벽이면 대각선 못감
                if ( board[i-1][j] == 1 || board[i][j-1] == 1 ) {
                    continue;
                }

                // 대각선
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                
            }
        }

        result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();
        System.out.println(result);
        
    }

    
}
