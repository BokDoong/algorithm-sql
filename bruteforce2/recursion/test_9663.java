package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_9663 {

    static int N;
    static int answer = 0;
    static int[] queen;

    /**
     * queen[x] = y
     * 체스판 x번째 줄의 y번째 자리에 둘 수 있다는 뜻
     */
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //main
        queen = new int[N];
        dfs(0);

        //output
        System.out.println(answer);
    }

    /**
     * @chess 현재 놓인 체스개수
     */
    public static void dfs(int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            queen[depth] = i;

            if(canVisitedCheck(depth))
                dfs(depth + 1);
        }
    }

    /**
     * (x,y) 좌표의 위,아래,양 옆,대각선 모두 true 변환
     */
    public static boolean canVisitedCheck(int depth) {
        for (int i = 0; i < depth; i++) {
            //양 옆, 위아래
            if (queen[depth] == queen[i]) {
                return false;
            }
            //대각선
            else if (Math.abs(depth - i) == Math.abs(queen[depth] - queen[i])) {
                return false;
            }
        }
        return true;
    }
}
