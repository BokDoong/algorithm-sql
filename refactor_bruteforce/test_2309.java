package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test_2309 {

    static int[] member = new int[9];
    static int[] result = new int[7];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            member[i] = Integer.parseInt(br.readLine());
        }

        //main
        Arrays.sort(member);
        solve(0, 0, 0);
    }

    private static void solve(int start, int depth, int total) {
        if (depth == 7) {
            if (total == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
                System.exit(0);
            }

            return;
        }

        for (int i = start; i < 9; i++) {
            result[depth] = member[i];
            solve(i + 1, depth + 1, total + member[i]);
        }
    }
}
