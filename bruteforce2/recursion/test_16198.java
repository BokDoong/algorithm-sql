package BaekJoon_Study.bruteforce2.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test_16198 {

    static int N;
    static int answer = Integer.MIN_VALUE;
    static List<Integer> nums;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(sc.nextInt());
        }

        //main
        dfs(0, 0, nums);

        //output
        System.out.println(answer);
    }

    public static void dfs(int depth, int sum, List<Integer> board) {
        if (depth == (N - 2)) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 1; i < board.size() - 1; i++) {
            int s = board.get(i-1) * board.get(i+1);
            int tmp = board.remove(i);
            dfs(depth + 1, sum+s, board);
            board.add(i, tmp);
        }
    }
}