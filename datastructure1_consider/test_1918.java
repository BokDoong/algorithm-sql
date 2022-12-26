package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_1918 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String word = br.readLine();
	
		for (int i=0; i<word.length(); i++) {
			char order = word.charAt(i);
			
			if ((int)order >= 65 && (int)order <= 90) {
				sb.append(order);
			}
			else if (order == '('){
				stack.push(order);
			}
			else if (order == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				stack.pop();
			}
			else {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(order))
					sb.append(stack.pop());
				stack.push(order);
			}
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb);
	}
	
	public static int priority(char op) {
		if (op == '(' || op == ')')
			return 0;
		else if (op == '+' || op == '-')
			return 1;
		else if(op == '*' || op == '/')
			return 2;
		
		return -1;
	}
}
