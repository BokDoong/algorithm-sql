package BaekJoon_Study.bruteforce2.permutation;

import java.util.Scanner;

public class test_14889 {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] stat;
    static boolean[] visited;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        stat = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                stat[i][j] = sc.nextInt();
            }
        }

        //main
        visited = new boolean[N + 1];
        dfs(0, 1);

        //output
        System.out.println(min);
    }

    //dfs
    public static void dfs(int depth, int now) {
        if (depth == N / 2) {
            //팀별 스탯 차이 계산
            min = Math.min(min, calTeam());

            if (min == 0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for (int i = now; i <= N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    //팀별 점수차이 계산
    public static int calTeam() {
        int scoreStart = 0;
        int scoreLink = 0;

        for (int i = 1; i <= N-1; i++) {
            for (int j = i + 1; j <= N; j++) {
                //true - 스타트팀
                if (visited[i] == true && visited[j] == true) {
                    scoreStart += stat[i][j];
                    scoreStart += stat[j][i];
                }
                //false - 링크팀
                else if (visited[i] == false && visited[j] == false) {
                    scoreLink += stat[i][j];
                    scoreLink += stat[j][i];
                }
            }
        }
        return Math.abs(scoreStart - scoreLink);
    }
}
