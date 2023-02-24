package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class test_13193 {

    static int N, K;
    static int[] visited;
    static int[] parent;
    static Queue<Integer> queue;

    static int bfs(int now){
        queue.offer(now);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            int next;

            if (num == K) {
                return visited[num];
            }

            //+1
            next = num+1;
            if(next <= 100000 && visited[next] == 0) {
                visited[next] = visited[num] + 1;
                parent[next] = num;
                queue.add(next);
            }

            //-1
            next = num-1;
            if(next >= 0 &&visited[next] == 0) {
                visited[next] = visited[num] + 1;
                parent[next] = num;
                queue.add(next);
            }

            //*2
            next = num*2;
            if(next <= 100000 && visited[next] == 0) {
                visited[next] = visited[num]+1;
                parent[next] = num;
                queue.add(next);
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        //main
        visited = new int[100001];
        parent = new int[100001];
        queue = new LinkedList<>();

        //output
        System.out.println(bfs(N));

        Stack<Integer> stack = new Stack<>();
        stack.add(K);
        int index = K;
        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
