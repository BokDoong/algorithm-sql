package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_15650 {

    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] answer;
    static boolean[] visited = new boolean[10];

    // 1~N 중에서 M개 뽑기
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        //main
        answer = new int[M];
        dfs(0, 1);

        //output
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
