package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1476 {

    static int[] input = new int[3];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //main
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[3];
        for (int i = 1; i <= 7980; i++) {
            result[0] = i % 15;
            if(i%15==0)
                result[0] = 15;

            result[1] = i % 28;
            if(i%28==0)
                result[1] = 28;

            result[2] = i % 19;
            if(i%19==0)
                result[2] = 19;

            if (check(result)) {
                System.out.println(i);
                System.exit(0);
            }
        }

        //output
    }

    static boolean check(int[] result) {
        boolean flag = true;

        for (int i = 0; i < 3; i++) {
            if(input[i] != result[i])
                flag = false;
        }

        return flag;
    }
}
