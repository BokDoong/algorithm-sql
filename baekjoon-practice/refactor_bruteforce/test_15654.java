package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_15654 {

    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static boolean[] visited;
    static int[] num;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // main
        answer = new int[M];
        visited = new boolean[N];

        Arrays.sort(num);
        dfs(N, M, 0);

        // output
        System.out.println(sb);
    }

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = num[i];
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }

}
