package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_14501 {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] time, price;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        time = new int[N+1];
        price = new int[N+1];
        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

        //main
        dfs(1, 0);

        //output
        System.out.println(max);
    }

    /**
     * day - 현재 날짜, now - 현재 가격
     */
    static void dfs(int day, int money) {
        if (day > N){
            max = Math.max(max, money);
            return;
        }

        //당일 체크
        if(day+time[day]-1 <= N)
            dfs(day + time[day], money + price[day]);
        //그냥 다음 날로 넘어가는 경우
        dfs(day + 1, money);
    }
}
