package datastructure1;

import java.util.*;
import java.io.*;

public class test_1406 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스택 생성
		Stack<Character> right_stack = new Stack<>();
		Stack<Character> left_stack = new Stack<>();

		//입력
		String input = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		//스택에 저장
		for(int i=0; i<input.length(); i++)
			left_stack.push(input.charAt(i));
		
		//main
		while(n-- > 0) {
			String [] x = br.readLine().split(" ");
			switch (x[0]) {
			case "P" :
				left_stack.push(x[1].charAt(0));
				break;
			case "L" :
				if (!left_stack.isEmpty()) {
					right_stack.push(left_stack.pop());
					break;
				}
				else
					break;
			case "D" :
				if (!right_stack.isEmpty()) {
					left_stack.push(right_stack.pop());
					break;
				}
				else
					break;
			case "B" :
				if (!left_stack.isEmpty()) {
					left_stack.pop();
					break;	
				}
				else
					break;
			}
		}
		
		//result
		StringBuilder sb = new StringBuilder();
		while(!left_stack.isEmpty())
			right_stack.push(left_stack.pop());
		while(!right_stack.isEmpty())
			sb.append(right_stack.pop());
		
		System.out.println(sb);
	}
}
