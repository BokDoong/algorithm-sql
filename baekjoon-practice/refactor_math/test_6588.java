package BaekJoon_Study.refactor_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_6588 {

    /** false: 소수, true: 소수x **/
    static boolean[] check = new boolean[1000001];
    static void prime() {
        check[1] = true;
        for (int i = 2; i < (int) Math.sqrt(1000001); i++) {
            if (!check[i]) {
                int tmp = 2;
                int num = i;
                while (num < 1000001) {
                    num = i * tmp;
                    if (num < 1000001) {
                        check[num] = true;
                        tmp++;
                    }
                }
            }
        }
    }

    static StringBuilder sb = new StringBuilder();
    static void solve(int num) {
        boolean tmp = false;
        for (int i = 3; i <= (int) num / 2; i+=2) {
            if (!check[i] && !check[num - i]) {
                tmp = true;
                sb.append(num + " = " + i + " + " + (num-i) + "\n");
                return;
            }
        }
        if (!tmp)
            sb.append("Goldbach's conjecture is wrong.\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prime();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0)
                break;

            solve(num);
        }

        System.out.println(sb);
    }
}
