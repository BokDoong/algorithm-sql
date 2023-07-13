package BaekJoon_Study.refactor_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test_9012 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            boolean check = true;
            Stack<Character> stack = new Stack<>();
            String vps = br.readLine();

            for (int j = 0; j < vps.length(); j++) {
                switch (vps.charAt(j)) {
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if (!stack.isEmpty())
                            stack.pop();
                        else
                            check = false;
                }
            }

            if(!stack.isEmpty() || check == false)
                sb.append("NO").append("\n");
            else
                sb.append("YES").append("\n");
        }

        System.out.println(sb);
    }
}
