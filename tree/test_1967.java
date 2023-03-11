package BaekJoon_Study.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class test_1967 {

    static int N;
    static int max = 0;
    static int node = 0;
    static boolean[] visited;
    static ArrayList<Node>[] list;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N-1; i++) {
            int p = sc.nextInt();
            int s = sc.nextInt();
            int w = sc.nextInt();

            list[p].add(new Node(s, w));
            list[s].add(new Node(p, w));
        }

        //main
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[node] = true;
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int now, int len) {

        if (max < len) {
            max = len;
            node = now;
        }

        for (Node node : list[now]) {
            if (visited[node.data])
                continue;

            visited[node.data] = true;
            dfs(node.data, len + node.weight);
        }
    }

    public static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }
}
