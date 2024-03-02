package BaekJoon_Study.refactor_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test_11052 {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        ArrayList<Integer> card = new ArrayList<>();
        card.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            card.add(Integer.parseInt(st.nextToken()));
        }

        //main
        dp[0] = 0; dp[1] = card.get(1);
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + card.get(i - j));
            }
        }

        //output
        System.out.println(dp[N]);
    }
}
