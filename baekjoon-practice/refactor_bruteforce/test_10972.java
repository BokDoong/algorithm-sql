package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_10972 {

    static int[] num;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        num = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(input[i]);

        // main
        if (np(N)) {
            for (int i = 0; i < N; i++) {
                System.out.print(num[i] + " ");
            }
        } else {
            System.out.println(-1);
        }

        // output
    }

    static boolean np(int N) {
        int i = N - 1;
        while(i>0 && num[i-1]>=num[i])
            --i;

        if(i==0)
            return false;

        int j = N-1;
        while(num[i-1]>=num[j])
            --j;

        swap(i - 1, j);
        int k = N - 1;
        while (i < k) {
            swap(i++, k--);
        }

        return true;
    }

    static void swap(int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
