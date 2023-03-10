package BaekJoon_Study.tree;

import java.util.*;

public class test_11725 {

    static List<Integer>[] list;
    static Queue<Integer> queue;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) {
        //input - N
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list[x].add(y);
            list[y].add(x);
        }

        //main
        //루트는 1, 탐색
        queue = new LinkedList<>();
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < list[now].size(); i++) {
                int tmp = list[now].get(i);
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    answer[tmp] = now;
                    queue.add(tmp);
                }
            }
        }
    }
}
