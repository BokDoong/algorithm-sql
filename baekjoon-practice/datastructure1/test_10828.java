package BaekJoon_Study.datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test_10828 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] com = br.readLine().split(" ");
            switch (com[0]) {
                case "push":
                    stack.push(Integer.parseInt(com[1]));
                    break;
                case "pop":
                    if (stack.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.pop()).append("\n");
                    break;
                case "top":
                    sb.append(stack.peek()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    int res = stack.isEmpty() ? 1 : 0;
                    sb.append(res).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
