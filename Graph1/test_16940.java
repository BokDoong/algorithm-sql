package BaekJoon_Study.Graph1;

import java.util.*;

public class test_16940 {

    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static Queue<Integer> queue = new LinkedList<>();

    static boolean bfs(){

        queue.add(1);
        visited[1] = true;

        int idx = 1;
        HashSet<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            set.clear();
            int num = queue.poll();

            for (int i = 0; i < graph[num].size(); i++) {
                int next = graph[num].get(i);

                if (visited[next] == false) {
                    set.add(next);
                    visited[next] = true;
                }
            }

            int size = set.size();
            for (int i = idx; i < idx + size; i++) {
                if (set.contains(answer[i])) {
                    queue.offer(answer[i]);
                } else {
                    return false;
                }
            }

            idx += size;
        }
        return true;
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

        for (int i = 0; i < N-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = sc.nextInt();
        }

        //main
        if(bfs()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
