package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_10974 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited = new boolean[10];
    static int[] answer;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // main
        answer = new int[N];
        dfs(0, N);

        // output
        System.out.println(sb);
    }

    static void dfs(int depth, int N) {
        if (depth == N) {
            for (int i = 0; i < N; i++)
                sb.append(answer[i]).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                dfs(depth + 1, N);
                visited[i] = false;
            }
        }
    }

}
