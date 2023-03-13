package BaekJoon_Study.bruteforce2.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class test_1339 {

    static int N;
    static int answer = 0;
    static int[] alphabet = new int[26];

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String num = sc.nextLine();
            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);
                alphabet[ch - 'A'] += Math.pow(10, num.length() - j - 1);
            }
        }

        //main
        Arrays.sort(alphabet);
        int order = 25;
        int product = 9;
        while (alphabet[order] != 0) {
            answer += alphabet[order]*product;
            product--;
            order--;
        }

        //output
        System.out.println(answer);
    }
}
