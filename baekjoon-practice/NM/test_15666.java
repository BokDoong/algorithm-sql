package BaekJoon_Study.NM;

import java.util.*;

public class test_15666 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] result = new int[10];
    public static int[] test;
    public static int N;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //input
        String[] str = sc.nextLine().split(" ");
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        test = new int[N];
        str = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++)
            test[i] = Integer.parseInt(str[i]);

        //main
        Arrays.sort(test);
        dfs(0,0, M);

        //output
        System.out.println(sb);
    }

    public static void dfs(int now,int idx, int size) {
        if(idx == size){
            for (int i = 0; i < size; i++) {
                sb.append(result[i]);
                if(i!=size-1)
                    sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = now; i < N; i++) {

            if (before != test[i]) {
                result[idx]=test[i];
                before = test[i];
                dfs(i,idx + 1, size);
            }
        }

    }
}

