package BaekJoon_Study.Permutation;

import java.util.Scanner;

public class test_6603 {
    public static int N;
    public static int[] nums;
    public static int[] result = new int[6];

    public static void total_permutation(int idx, int start){
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println("");
            return;
        }

        for (int i = start; i < N; i++) {
            result[idx] = nums[i];
            total_permutation(idx + 1, i+1);

        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            //input
            String[] str = sc.nextLine().split(" ");
            N = Integer.parseInt(str[0]);
            if(N == 0)
                break;

            nums = new int[N];
            for(int i=0; i<N; i++)
                nums[i] = Integer.parseInt(str[i+1]);

            //main
            total_permutation(0, 0);

            //output
            System.out.println();
        }
    }
}
