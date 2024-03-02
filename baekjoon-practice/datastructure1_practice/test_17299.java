package datastructure1_practice;
import java.util.*;
import java.io.*;

public class test_17299 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//init
		int n = Integer.parseInt(br.readLine());
		int [] input = new int[n];
		int [] origin = new int[1000001];
		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			input[i] = tmp;
			origin[tmp] += 1;
		}
		
		//main
		//stack: 인덱스 저장하는 스택
		Stack <Integer> stack = new Stack<>();
		for (int i=0; i<n; i++) {
			int tmp = input[i];
			
			while(!stack.isEmpty() && origin[tmp] > origin[input[stack.peek()]]) {
				input[stack.pop()] = tmp;
			}
			stack.push(i);
		}
		
		//남아있는거 다 -1
		while(!stack.isEmpty())
			input[stack.pop()] = -1;

		//output
		for(int i=0; i<n; i++)
			sb.append(input[i]).append(" ");
		System.out.println(sb);
	}
}
