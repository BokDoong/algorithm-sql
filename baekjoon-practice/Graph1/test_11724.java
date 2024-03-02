package BaekJoon_Study.Graph1;

import java.util.ArrayList;
import java.util.Scanner;

public class test_11724 {
    static int N,M;
    static int result = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int now) {

        visited[now] = true;
        for (int i = 0; i < graph[now].size(); i++) {
            int tmp = graph[now].get(i);
            if(visited[tmp]==false)
                dfs(tmp);
        }
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        //main
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                dfs(i);
                result++;
            }
        }

        //output
        System.out.println(result);
    }
}
