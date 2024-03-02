package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_13549 {

    static int N, K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        visited = new boolean[100001];
        bfs();
        System.out.println(min);
    }

    public static void bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();
            if (now.total == K) {
                min = Math.min(min, now.time);
            }

            //*2
            if (now.total * 2 <= 100000 && !visited[now.total * 2]) {
                visited[now.total*2] = true;
                queue.offer(new Node(now.total * 2, now.time));
            }

            //-1
            if (now.total - 1 >= 0 && !visited[now.total - 1]) {
                visited[now.total-1] = true;
                queue.offer(new Node(now.total - 1, now.time + 1));
            }

            //+1
            if (now.total + 1 <= 100000 && !visited[now.total + 1]) {
                visited[now.total+1] = true;
                queue.offer(new Node(now.total + 1, now.time + 1));
            }
        }
    }

    public static class Node {
        int total;
        int time;

        public Node(int total, int time) {
            this.total = total;
            this.time = time;
        }
    }
}
