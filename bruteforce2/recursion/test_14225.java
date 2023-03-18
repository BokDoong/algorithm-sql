package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_14225 {

    static int N;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        //main
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += nums[i];
        }

        visited = new boolean[total+2];
        dfs(0, 0);

        //output
        for (int i = 0; i < total+2; i++) {
            if(!visited[i]) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            visited[sum] = true;
            return;
        }

        dfs(depth + 1, sum + nums[depth]);
        dfs(depth + 1, sum);
    }
}
