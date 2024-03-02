package BaekJoon_Study.refactor_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_9095 {
    public static void main(String[] args) throws IOException {
        //input
        int[] dp = new int[12];
        dp[1] = 1; dp[2] = 2; dp[3]=4;

        //main
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        //output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }

    }
}
