package BaekJoon_Study.Graph1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_1260 {
    static int N, M , V;
    static int[][] branch;
    static boolean[] visited;
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int now) {
        visited[now] = true;
        sb.append(now + " ");

        for (int i = 1; i <= N; i++) {
            if(branch[now][i]==1 && visited[i]==false)
                dfs(i);
        }

    }

    static void bfs(int now) {
        queue = new LinkedList<Integer>();
        queue.add(now);
        visited[now] = true;
        sb.append(now + " ");

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for(int i=1; i<branch.length; i++){
                if (branch[tmp][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        branch = new int[1001][1001];
        visited = new boolean[1001];

        //main
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b= sc.nextInt();

            branch[a][b] = 1;
            branch[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);


        //output
        System.out.println(sb);
    }
}
