package BaekJoon_Study.refactor_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_10973 {

    static int[] num;

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        num = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        //main
        int i = N - 1;
        while (i>0 && num[i] >= num[i - 1]) {
            i--;
        }

        if (i == 0) {
            System.out.println(-1);
            System.exit(0); // 종료
        }

        // num[i-1]보다 작은 수 찾기
        int j = N - 1;
        while (num[i-1] <= num[j]) {
            j--;
        }

        swap(i - 1, j);

        //나머지 정렬
        int k = N - 1;
        while (i < k) {
            swap(i++, k--);
        }

        //output
        for (int p = 0; p < N; p++) {
            System.out.print(num[p] + " ");
        }
    }

    static void swap(int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

}
