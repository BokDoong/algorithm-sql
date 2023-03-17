package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_1182 {

    static int target, N;
    static int answer = 0;
    static int[] nums;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        target = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        //main
        dfs(0, 0);

        //output
        if (target == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }

    public static void dfs(int now, int sum) {
        if (now == N) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(now + 1, sum);
        dfs(now + 1, sum + nums[now]);
    }
}