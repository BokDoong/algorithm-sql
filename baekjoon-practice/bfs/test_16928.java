package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_16928 {

    static int[] visited = new int[101];
    static int[] jump = new int[101];

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        for (int i = 0; i < (x + y); i++) {
            int tmp = sc.nextInt();
            jump[tmp] = sc.nextInt();
        }

        //main&output
        System.out.println(bfs(1));
    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if(now == 100)
                return visited[100];

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if(next > 100)
                    continue;

                if (jump[next] > 0) {
                    next = jump[next];
                }
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
