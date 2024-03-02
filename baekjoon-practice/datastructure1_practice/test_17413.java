package datastructure1_practice;
import java.util.*;
import java.io.*;

public class test_17413 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		String input = br.readLine();
		
		//���� ���� ���� -> ������ ������ input�� ������ �ö� ���� ������
		//" "������ ���� ���� �� �Ųٷ�
		//"<"������ ">"���� ������ while��(����++) -> �״�� ���
		int idx = 0;
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		//main
		//������(��ĭ, <>)
		while(idx < input.length()) {
			if(input.charAt(idx) == '<') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				
				while(input.charAt(idx) != '>') {
					sb.append(input.charAt(idx));
					idx += 1;
				}
				sb.append('>');
			}
			else if(input.charAt(idx) == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(' ');
			}
			else
				stack.push(input.charAt(idx));
			idx += 1;
		}
		
		//stack �����ִ°� �ֱ�
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		//���
		System.out.println(sb);
	}

}
