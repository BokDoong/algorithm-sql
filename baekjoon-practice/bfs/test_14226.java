package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_14226 {

    // [clipboard][total]
    static boolean[][] visited = new boolean[1001][1001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();

        bfs(S);
    }

    public static void bfs(int S) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, 0));
        visited[0][1] = true;   //현재 이모티콘 - 1

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if(current.total == S){
                System.out.println(current.time);
                return;
            }

            //클립보드 저장
            queue.offer(new Node(current.total, current.total, current.time + 1));

            //붙여넣기(클립보드 안에 숫자가 있어야함)
            if (current.clipboard != 0 && current.total + current.clipboard <= S && !visited[current.clipboard][current.total + current.clipboard]) {
                queue.offer(new Node(current.clipboard, current.total + current.clipboard, current.time + 1));
                visited[current.clipboard][current.total+current.clipboard] = true;
            }

            // -1
            if (current.total >= 1 && !visited[current.clipboard][current.total - 1]) {
                queue.offer(new Node(current.clipboard, current.total - 1, current.time + 1));
                visited[current.clipboard][current.total - 1] = true;
            }

        }
    }

    public static class Node {
        int clipboard;
        int total;
        int time;

        public Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
