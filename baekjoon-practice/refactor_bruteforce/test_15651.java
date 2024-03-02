package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_15651 {

    static StringBuilder sb = new StringBuilder();
    static int[] answer;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        //main
        answer = new int[M];
        dfs(N, M, 0);

        //output
        System.out.println(sb);
    }

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            answer[depth] = i;
            dfs(N, M, depth + 1);
        }
    }
}
