package BaekJoon_Study.refactor_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_11726 {

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        // main
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 1001; i++) {
            dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007;
        }

        // output
        System.out.println(dp[target]);
    }
}
