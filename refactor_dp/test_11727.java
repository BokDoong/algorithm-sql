package BaekJoon_Study.refactor_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_11727 {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        //main
        int[] dp = new int[size + 1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i < size + 1; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        //output
        System.out.println(dp[size]);
    }
}
