package BaekJoon_Study.BruteForce.Recursion;

import java.util.Scanner;

public class test_9095 {
    public static int result;
    public static int sum;

    public static void test(int n, int now) {
        if (now == n) {
            result++;
            return;
        }

        //n = 4
        //1111
        for (int i = 1; i <= 3; i++) {
            if (now > n)
                continue;


            sum += i;
            test(n, sum);
            sum -= i;
        }
    }

    public static void main(String args[]) {
        //input
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        //main
        while (T > 0) {
            int num = sc.nextInt();

            result = 0; sum = 0;
            test(num, 0);

            System.out.println(result);
            T--;
        }

        //output
    }
}
