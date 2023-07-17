package BaekJoon_Study.refactor_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_1929 {

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

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //main
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        prime();
        for (int i = start; i <= end; i++) {
            if(!check[i])
                System.out.println(i);
        }
    }
}
