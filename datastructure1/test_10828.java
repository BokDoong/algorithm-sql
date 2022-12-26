package datastructure1;
import java.util.*;
import java.io.*;

public class test_10828 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			
			switch(x) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
				break;
			}
		}
		
	}
}
