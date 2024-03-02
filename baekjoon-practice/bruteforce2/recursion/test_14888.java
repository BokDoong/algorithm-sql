package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_14888 {

    static int N;
    static int[] nums;
    static int[] op = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        //연산자 - 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        //main
        dfs(1, nums[0]);

        //output
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] == 0)
                continue;

            op[i]--;
            switch (i) {
                case 0:
                    dfs(depth + 1, sum + nums[depth]);
                    break;
                case 1:
                    dfs(depth + 1, sum - nums[depth]);
                    break;
                case 2:
                    dfs(depth + 1, sum * nums[depth]);
                    break;
                case 3:
                    dfs(depth + 1, sum / nums[depth]);
                    break;
            }
            op[i]++;
        }
    }
}
