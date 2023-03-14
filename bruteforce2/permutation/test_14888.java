package BaekJoon_Study.bruteforce2;

import java.util.Scanner;

public class test_14888 {

    public static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    //순열
    public static int[] nums;
    //연산자 개수(+, -, *, /)
    public static int[] op = new int[4];

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //nums
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        //main
        dfs(1, nums[0]);

        //output
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int num) {
        if (depth == N) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0:
                        dfs(depth + 1, num + nums[depth]);
                        break;
                    case 1:
                        dfs(depth + 1, num - nums[depth]);
                        break;
                    case 2:
                        dfs(depth + 1, num * nums[depth]);
                        break;
                    case 3:
                        dfs(depth + 1, num / nums[depth]);
                        break;
                }

                op[i]++;
            }
        }
    }
}
