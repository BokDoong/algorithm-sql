package BaekJoon_Study.bruteforce2.permutation;

import java.util.Scanner;

public class test_2529 {

    static int N;
    static String[] test;
    static boolean[] visited;
    static String max = "0";
    static String min = "10000000000";

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sc.nextLine();
        test = sc.nextLine().split(" ");

        //main
        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            search(0, i, String.valueOf(i));
            visited[i] = false;
        }
        System.out.println(max);
        System.out.println(min);
    }

    public static void search(int length, int prev, String num) {
        if (length == N) {
            if (Long.parseLong(num) > Long.parseLong(max)) {
                max = num;
            }
            if (Long.parseLong(num) < Long.parseLong(min)) {
                min = num;
            }

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i] = true) {
                continue;
            }

            if (test[length].equals(">") && prev > i) {
                visited[i] = true;
                search(length + 1, i, num + String.valueOf(i));
                visited[i] = false;
            }
            if (test[length].equals("<") && prev < i) {
                visited[i] = true;
                search(length + 1, i, num + String.valueOf(i));
                visited[i] = false;
            }
        }
    }
}
