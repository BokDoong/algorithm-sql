package BaekJoon_Study.Graph1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class test_16964 {

    static int N, idx;
    static int[] answer;
    static boolean check;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void dfs(int x){

        if (visited[x])
            return;

        visited[x] = true;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < graph[x].size(); i++) {
            int next = graph[x].get(i);

            if (visited[next])
                continue;
            set.add(next);
        }

        if(set.size() == 0)
            return;

        if (set.contains(answer[idx])) {
            dfs(answer[idx++]);
        }
        else {
            check = false;
        }
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //initializing
        visited = new boolean[N + 1];
        check = true;

        for (int i = 0; i < N-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        answer = new int[N];
        for(int i=0; i<N; i++)
            answer[i] = sc.nextInt();

        if(answer[0] != 1) {
            System.out.println(0);
            return;
        }

        //main
        idx = 1;
        dfs(1);

        if(check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
