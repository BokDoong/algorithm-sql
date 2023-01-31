package BaekJoon_Study.Permutation;

import java.util.Scanner;

public class test_10971 {
    public static int[][] path;
    public static boolean[] check = new boolean[10];
    public static int[] out = new int[10];
    public static int result = Integer.MAX_VALUE;

    public static void total_permutation(int idx, int size) {
        if (idx == size) {
            int tmp = 0;

            //비용 계산
            for (int i = 0; i < size-1; i++) {
                if (path[out[i]][out[i + 1]] == 0)
                    return;

                tmp += path[out[i]][out[i+1]];
            }

            //result
            if(path[out[size-1]][out[0]]!=0){
                tmp +=  path[out[size-1]][out[0]];
                result = Math.min(result, tmp);
            }
        }

        for (int i = 0; i < size; i++) {
            if (check[i])
                continue;

            check[i] = true;
            out[idx] = i;
            total_permutation(idx + 1, size);
            check[i] = false;
        }
    }

    public static void main(String args[]) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        path = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                path[i][j] = Integer.parseInt(str[j]);
            }
        }

        //main
        total_permutation(0, N);

        //output
        System.out.println(result);
    }
}
