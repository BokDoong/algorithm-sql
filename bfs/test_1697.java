package BaekJoon_Study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_1697 {

    static int N, K;
    static int[] visited;
    static Queue<Integer> queue;

    static int bfs(int now){
        queue.offer(now);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == K) {
                return visited[num];
            }

            //+1
            if(num+1 <= 100000 && visited[num+1] == 0) {
                visited[num+1] = visited[num] + 1;
                queue.add(num + 1);
            }

            //-1
            if(num-1 >= 0 &&visited[num-1] == 0) {
                visited[num-1] = visited[num] + 1;
                queue.add(num - 1);
            }

            //*2
            if(num*2 <= 100000 && visited[num*2] == 0) {
                visited[num*2] = visited[num]+1;
                queue.add(num * 2);
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
        queue = new LinkedList<>();

        //output
        System.out.println(bfs(N));;
    }
}
