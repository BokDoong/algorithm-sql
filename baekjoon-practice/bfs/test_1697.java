package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_1697 {

    static int K;
    static int[] visited;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();

        //main
        visited = new int[100001];
        bfs(N);

        //output
        System.out.println(visited[K]);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(now == K)
                return;

            int nx = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0)
                    nx = now + 1;
                else if (i == 1)
                    nx = now - 1;
                else
                    nx = now*2;

                if(nx > 100000 || nx < 0)
                    continue;

                if (visited[nx] == 0) {
                    visited[nx] = visited[now] + 1;
                    queue.add(nx);
                }
            }

        }
    }
}
