import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] nums;
    static int[][] dp;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for ( int n = 0 ; n < N ; n++ ) {
            nums[n] = Integer.parseInt(st.nextToken());
        }
        
    }

    static void initialize() {
        dp = new int[N][N];
        for ( int n = 0 ; n < N ; n++ ) {
            Arrays.fill(dp[n], -1);
        }
    }

    static int solve(int left, int right) {

        // 포인터가 같아지면 끝
        if ( left >= right ) {
            return 0;
        }

        // 이미 찾은 값이면 바로 반환
        if ( dp[left][right] != -1 ) {
            return dp[left][right];
        }

        int min = 0;

        // 팰린드롬이라면 그대로 ㄱ
        if ( nums[left] == nums[right] ) {
            min = solve(left+1, right-1);
        }
        // 아니라면 왼쪽, 오른쪽 하나씩 추가해서 돌리고 최솟값으로 대체
        else {
            min = Math.min(solve(left+1, right), solve(left, right-1)) + 1;
        }

        dp[left][right] = min;
        return min;
        
    }

    
    public static void main(String[] args) throws IOException {

        input();
        initialize();
        System.out.println(solve(0, N-1));
        
    }

}
