package BaekJoon_Study.refactor_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1978 {

    /** false: 소수, true: 소수아님 **/
    static boolean[] check = new boolean[1001];

    static void prime() {
        check[0] = true; check[1] = true;
        for (int i = 2; i < (int)Math.sqrt(1000)+1; i++) {
            if (!check[i]) {
                int num = i;
                int tmp = 2;
                while (num < 1001) {
                    num = i * tmp;
                    if(num<1001)
                        check[num] = true;

                    tmp++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        //main
        int cnt = 0;
        prime();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if(!check[Integer.parseInt(st.nextToken())])
                cnt++;
        }

        //output
        System.out.println(cnt);
    }
}
