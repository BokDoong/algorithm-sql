package BaekJoon_Study.bruteforce2.bitmask;

import java.util.Scanner;

public class test_1062 {

    static int N, K;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited = new boolean[26];
    static String[] words;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if (K < 5) {
            System.out.println(0);
            System.exit(0);
        }

        sc.nextLine();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            words[i] = input.substring(4, input.length() - 4);
        }

        //main
        char[] known = {'a', 'n', 't', 'i', 'c'};
        for (int i = 0; i < known.length; i++) {
            visited[known[i] - 'a'] = true;
        }
        dfs(0, 0);

        //output
        System.out.println(max);
    }

    static void dfs(int depth, int now) {
        if (depth == K - 5) {
            max = Math.max(canRead(), max);
            return;
        }

        for (int i = now; i < 26; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    static int canRead() {
        int read = 0;
        for (String word : words) {
            boolean check = true;
            for (int i = 0; i < word.length(); i++) {
                if (!visited[word.charAt(i)-'a'])
                    check = false;
            }
            if(check)
                read++;
        }

        return read;
    }
}
