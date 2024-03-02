package BaekJoon_Study.BruteForce.Recursion;

import java.util.Scanner;

public class test_14889 {
    static int N;
    static int result=Integer.MAX_VALUE;
    static int[][] stat;
    static boolean[] visited;


    public static void dfs(int depth, int start) {
        if (depth == N/2) {
            diff();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        stat = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            String[] str = sc.nextLine().split(" ");
            for (int j = 1; j < N+1; j++) {
                stat[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        visited = new boolean[N + 1];
        dfs(0,1);
        System.out.println(result);
    }

    public static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    team_start += stat[i][j];
                    team_start += stat[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    team_link += stat[i][j];
                    team_link += stat[j][i];
                }
            }
        }

        int val = Math.abs(team_link - team_start);
        if (val == 0) {
            System.out.println(0);
            System.exit(0);
        }

        result = Math.min(result, val);
    }
}
