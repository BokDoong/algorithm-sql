package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_15649 {

    static StringBuilder sb = new StringBuilder();

    static boolean[] visited = new boolean[10];
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // main
        arr = new int[M];
        dfs(0);

        // output
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int var : arr)
                sb.append(var).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);

                visited[i] = false;
            }
        }

        return;
    }
}
