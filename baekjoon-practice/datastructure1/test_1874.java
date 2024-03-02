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
			//���� �ϳ��� �Է� �ޱ�
			int value = Integer.parseInt(br.readLine());
			//last_value�� �� vs value => �ϳ��� append, +1
			if(last_value < value) {
				for (int j=last_value+1; j<=value; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				last_value = value;
			}
			//stack.peek�� last_value ��� value�� ���� ũ�� -> NO
			else {
				if (stack.peek() > value) {
					System.out.println("NO");
					return;
				}
			}
			//������ -> pop()
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
