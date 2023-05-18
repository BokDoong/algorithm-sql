package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class test_13193 {

    static int N, K;
    static int[] visited;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        //main
        visited = new int[100001];
        parent = new int[100001];
        bfs();

        //output
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int order = K; //17
        while (order != N) {
            stack.push(parent[order]);
            order = parent[order];
        }

        System.out.println(visited[K]);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now + 1 < 100001 && visited[now + 1] == 0) {
                queue.add(now + 1);
                parent[now + 1] = now;
                visited[now+1] = visited[now]+1;
            }

            if (now - 1 >= 0 && visited[now - 1] == 0) {
                queue.add(now - 1);
                parent[now - 1] = now;
                visited[now-1] = visited[now]+1;
            }

            if (now*2 < 100001 && visited[now*2] == 0) {
                queue.add(now*2);
                parent[now*2] = now;
                visited[now*2] = visited[now] + 1;
            }
        }
    }
}
