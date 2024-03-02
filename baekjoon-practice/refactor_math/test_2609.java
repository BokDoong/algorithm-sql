package BaekJoon_Study.refactor_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_2609 {

    static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //main
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        //output
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
}
