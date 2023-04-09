package BaekJoon_Study.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_9019 {

    static boolean[] visited;
    static String[] answer;
    static char[] command = {'D', 'S', 'L', 'R'};
    static int target;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //main
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            target = sc.nextInt();

            answer = new String[10000];
            Arrays.fill(answer, "");

            visited = new boolean[10000];
            visited[start] = true;
            System.out.println(bfs(start));
        }
    }

    static String bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if(now == target)
                return answer[now];

            for (int i = 0; i < 4; i++) {
                int next = changeNum(now, command[i]);

                if (!visited[next]) {
                    answer[next] = answer[now] + command[i];
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return "error";
    }

    static int changeNum(int num, char com) {
        int result = 0;

        if (com == 'D') {
            result = num*2;
            if(result > 9999)
                result = result % 10000;
        } else if (com == 'S') {
            result = num-1;
            if(result == 0)
                result = 9999;
        } else if (com == 'L') {
            int first = num / 1000;
            num = num - (first * 1000);
            result = num * 10 + first;
        } else {
            int last = num % 10;
            num = num / 10;
            result = last * 1000 + num;
        }

        return result;
    }
}
