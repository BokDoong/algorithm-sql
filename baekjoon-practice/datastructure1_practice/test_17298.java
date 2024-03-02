package datastructure1_practice;
import java.util.*;
import java.io.*;

public class test_17298 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//input
		int n = Integer.parseInt(br.readLine());
		int [] input = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		//main
		//stack���� index�� �ֱ�
		//������ ���� peek���� ���� ���� ���� ������ stack.pop()�� index�� �ش��ϴ� value�� ������ ������ �ٲ�
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<n; i++) {
			int tmp = input[i];
				
			while(!stack.isEmpty() && tmp > input[stack.peek()]) {
				input[stack.pop()] = tmp;
			}
			
			stack.push(i);
		}
		//������ -1
		while(!stack.isEmpty())
			input[stack.pop()] = -1;
		
		//output
		for(int i=0; i<n; i++)
			sb.append(input[i]).append(" ");
		System.out.println(sb);
	}
}
