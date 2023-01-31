package BaekJoon_Study.Permutation;

import java.util.Scanner;

public class test_10819 {
    public static boolean[] check = new boolean[10];
    public static int[] out = new int[10];
    public static int[] nums;
    public static int result = 0;

    public static void total_permutation(int idx, int size) {
        if (idx == size) {
            int tmp = 0;

            //A[i-1]-A[i] 절대값의 합을 구하는 식
            for (int i = 0; i < size-1; i++) {
                tmp += Math.abs(out[i] - out[i+1]);
            }

            //result
            result = Math.max(result, tmp);
        }

        for (int i = 0; i < size; i++) {
            if (check[i])
                continue;

            check[i] = true;
            out[idx] = nums[i];
            total_permutation(idx + 1, size);
            check[i] = false;
        }
    }

    public static void main(String args[]) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        nums = new int[N];
        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(str[i]);

        //main
        total_permutation(0, N);

        //output
        System.out.println(result);
    }
}
