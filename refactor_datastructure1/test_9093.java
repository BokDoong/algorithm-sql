package BaekJoon_Study.refactor_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_9093 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /** I am happy today **/
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                for (int k = input[j].length()-1; k >= 0; k--) {
                    sb.append(input[j].charAt(k));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
