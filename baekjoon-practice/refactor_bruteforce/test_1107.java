package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1107 {

    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 목표버튼
        int M = Integer.parseInt(br.readLine());    // 고장버튼 개수

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // main
        int result = Math.abs(N - 100); // 초기값: 100에서 +/-
        for (int i = 0; i <= 1000000; i++) {
            int len = check(i);   // 해당 숫자로 이동할 수 있는지 체크
            if (len > 0) {
                int press = Math.abs(N - i);
                result = Math.min(result, len + press);
            }
        }

        //output
        System.out.println(result);
    }

    static int check(int n) {
        if (n == 0) {
            if(broken[0])
                return 0;
            else
                return 1;
        }

        int len = 0;
        while (n > 0) {
            if (broken[n % 10]) {
                return 0;
            }
            n /= 10;
            len += 1;
        }

        return len;
    }
}
