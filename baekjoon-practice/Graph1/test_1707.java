package BaekJoon_Study.Graph1;

import java.util.ArrayList;
import java.util.Scanner;

public class test_1707 {

    static int T, V, E;
    static ArrayList<Integer>[] graph;
    static int[] color;


    static void dfs(int now, int c) {

        color[now] = c;

        for (int i = 0; i < graph[now].size(); i++) {
            int next = graph[now].get(i);
            if(color[next] == 0)
                dfs(next, 3-c); //인접한 노드는 다른 색이여야함
        }
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        //main
        for (int i = 0; i < T; i++) {
            V = sc.nextInt(); E = sc.nextInt();

            graph = new ArrayList[V+1];
            color = new int[V+1];

            //그래프 입력
            for(int j=0; j<=V; j++)
                graph[j] = new ArrayList<>();

            for (int j = 0; j < E; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int k = 1; k <= V; k++) {
                if (color[k] == 0) {
                    dfs(k,1);
                }
            }

            //색깔 비교
            boolean check = true;
            for (int k = 1; k <= V; k++) {
                for (int q = 0; q < graph[k].size(); q++) {
                    int tmp = graph[k].get(q);
                    if(color[k]==color[tmp])
                        check = false;
                }
            }
            System.out.println(check ? "YES" : "NO");
        }
    }
}
