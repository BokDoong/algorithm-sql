package BaekJoon_Study.bruteforce2.recursion;

import java.util.Scanner;

public class test_6603 {

    static int k;
    static boolean[] visited;
    static int[] lotto;
    static int[] answer;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        while (true) {
            //k
            k = sc.nextInt();
            if (k == 0)
                System.exit(0);

            //lotto
            lotto = new int[k];
            for (int i = 0; i < k; i++) {
                lotto[i] = sc.nextInt();
            }

            //dfs
            answer = new int[6];
            visited = new boolean[k];
            dfs(0, 0);
            System.out.println();
        }
    }

    //8: 1 2 3 5 8 13 21 34
    //dfs(0,0)
    public static void dfs(int now, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                if (i != 5) {
                    System.out.print(answer[i] + " ");
                } else {
                    System.out.println(answer[i]);
                }
            }
            return;
        }

        for (int i = now; i < k; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            answer[depth] = lotto[i];
            dfs(i, depth + 1);
            visited[i] = false;
        }
    }
}
