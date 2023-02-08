package BaekJoon_Study.Graph1;

import java.util.ArrayList;
import java.util.Scanner;

public class test_13023 {
    static int N,M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    static void dfs(int depth, int now) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }

        visited[now] = true;
        for (int i=0; i<list[now].size(); i++) {
            int tmp = list[now].get(i);
            if (visited[tmp] == false) {
                visited[tmp] = true;
                dfs(depth + 1, tmp);
                visited[tmp] = false;
            }
        }
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }   //N개의 연결리스트 생성

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b); list[b].add(a);
        }   //각 리스트에서 서로를 추가


        //main
        for(int i=0; i<N; i++){
            visited = new boolean[N];
            dfs(0, i);
        }

        //output
        System.out.println(0);
    }
}
