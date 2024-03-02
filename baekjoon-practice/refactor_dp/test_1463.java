package BaekJoon_Study.refactor_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_1463 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        dp = new int[size+1];
        for (int i = 0; i < size; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // main
        int order = size;
        while (order > 0) {
            if (order % 2 == 0) {
                dp[order/2] = Math.min(dp[order]+1, dp[order/2]);
            }
            if (order % 3 == 0) {
                dp[order/3] = Math.min(dp[order]+1, dp[order/3]);
            }
            dp[order - 1] = Math.min(dp[order] + 1, dp[order - 1]);

            order--;
        }

        // output
        System.out.println(dp[1]);
    }
}
