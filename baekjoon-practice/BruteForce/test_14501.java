package BaekJoon_Study.BruteForce.Recursion;

import java.util.Scanner;

public class test_14501 {
    public static int max;
    public static int[] time;
    public static int[] price;
    public static int[] result;


    public static void test(int now, int N, int total) {
        //날짜 채운경우
        if (now == N+1) {
            max = Math.max(max, total);
            return;
        }

        //날짜 초과
        if (now > N + 1)
            return;

        //다음날꺼
        test(now + 1, N, total);
        //띄워서
        test(now + time[now], N, total + price[now]);
    }

    public static void main(String args[]) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        time = new int[N+1];
        price = new int[N+1];
        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

        //main
        max = 0;
        test(1, N, 0);

        //output
        System.out.println(max);
    }
}
