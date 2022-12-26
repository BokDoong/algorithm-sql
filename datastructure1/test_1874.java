package datastructure1;

import java.util.*;
import java.io.*;

public class test_1874 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int last_value = 0;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for (int i=0; i<n; i++) {
			//수열 하나씩 입력 받기
			int value = Integer.parseInt(br.readLine());
			//last_value와 비교 vs value => 하나씩 append, +1
			if(last_value < value) {
				for (int j=last_value+1; j<=value; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				last_value = value;
			}
			//stack.peek과 last_value 모두 value값 보다 크다 -> NO
			else {
				if (stack.peek() > value) {
					System.out.println("NO");
					return;
				}
			}
			//같을때 -> pop()
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
