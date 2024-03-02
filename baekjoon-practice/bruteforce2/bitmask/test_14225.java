package BaekJoon_Study.bruteforce2.bitmask;

import java.util.Arrays;
import java.util.Scanner;

public class test_14225 {

    static int N;
    static int[] nums;
    static boolean[] visited = new boolean[2000001];

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); sc.nextLine();

        nums = new int[N];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        //main
        Arrays.sort(nums);
        dfs(0, 0);

        //output
        int order = 1;
        while (true) {
            if (!visited[order]) {
                System.out.println(order);
                System.exit(0);
            }
            order++;
        }
    }

    static void dfs(int depth, int sum) {
        if (depth == N) {
            visited[sum] = true;
            return;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + nums[depth]);
    }
}
