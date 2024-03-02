package BaekJoon_Study.BruteForce.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_1248 {

    static int n, sum;
    static String arr;
    static int[] result;
    static Character[][] map;

    static void dfs(int idx) {
        // 조건이 모두 성립되면 시스템종료
        if (idx == n) {
            String str = "";
            for(int i = 0; i < result.length; i++) {
                str += result[i] + " ";
            }
            System.out.print(str);

            // 시스템을 종료.
            System.exit(0);
        }

        // -10~10 까지 수를 비교
        for(int i = -10; i < 11; i++) {
            result[idx] = i;
            // 조건이 만족할 경우 true
            if(cheak(idx+1)) {
                dfs(idx+1);
            }
        }

    }

    static boolean cheak(int length) {
        // 조건이 만족하는지 확인
        for(int i = 0; i < length; i++) {
            int sum = 0;
            for(int j = i; j < length; j++) {
                sum += result[j];
                if(map[i][j] != (sum == 0 ? '0' : (sum > 0) ? '+' : '-')) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = br.readLine();
        map = new Character[n][n];

        // map 2차원 배열에 기호를 넣는다
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                map[i][j] = arr.charAt(idx++);
            }
        }

        // result : 조건에 만족하여 임의의 숫자를 셋팅한 배열
        result = new int[n];
        dfs(0);

    }

}
