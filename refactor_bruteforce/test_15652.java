package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_15652 {

    static StringBuilder sb = new StringBuilder();
    static int[] result;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // main
        result = new int[M];
        dfs(N, M, 1, 0);

        // output
        System.out.println(sb);
    }

    static void dfs(int N, int M, int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(result[i]).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            dfs(N, M, i, depth + 1);
        }
    }
}
