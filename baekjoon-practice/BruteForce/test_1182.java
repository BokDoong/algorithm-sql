package BaekJoon_Study.BruteForce.BitMask;

import java.util.Scanner;

public class test_1182 {
    static int[] nums;
    static int N, S;
    static int result = 0;

    public static void dfs(int now, int total) {
        if (now == N) {
            if(total == S)
                result++;
            return;
        }
        //현재의 수를 더하지 않을때
        dfs(now+1, total);
        //현재의 수를 더할 때
        dfs(now + 1, total + nums[now]);
    }

    public static void main(String args[]) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];
        for(int i=0; i<N; i++)
            nums[i] = sc.nextInt();

        //main
        dfs(0, 0);

        //output
        if(S==0)
            System.out.println(result-1);
        else
            System.out.println(result);

    }
}
