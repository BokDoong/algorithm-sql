package BaekJoon_Study.refactor_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_10430 {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        //main
        sb.append((a + b) % c).append("\n");
        sb.append(((a % c) + (b % c)) % c).append("\n");
        sb.append((a * b) % c).append("\n");
        sb.append(((a % c) * (b % c)) % c);

        //output
        System.out.println(sb);
    }
}
