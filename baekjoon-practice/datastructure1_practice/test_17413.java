package datastructure1_practice;
import java.util.*;
import java.io.*;

public class test_17413 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		String input = br.readLine();
		
		//순서 변수 설정 -> 변수가 순서가 input의 끝까지 올때 까지 돌리기
		//" "만나면 여태 담은 것 거꾸로
		//"<"만나면 ">"만날 때까지 while문(순서++) -> 그대로 출력
		int idx = 0;
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		//main
		//구분자(빈칸, <>)
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
		
		//stack 남아있는거 넣기
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		//출력
		System.out.println(sb);
	}

}
