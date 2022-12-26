package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_1935 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//setting
		//alpha : A~Z ¾ËÆÄºªÀÇ value
		int n = Integer.parseInt(br.readLine());
		int [] alpha = new int[n];
		
		//input
		String input = br.readLine();
		for(int i=0; i<n; i++)
			alpha[i] = Integer.parseInt(br.readLine());
	
		//main
		Stack <Double> stack = new Stack<>();
		for(int i=0; i<input.length(); i++) {
			char order = input.charAt(i);
			double tmp, fir_tmp, sec_tmp;
			
			if ((int)order >= 65 && (int)order < 90) {
				stack.push((double)alpha[(int)order-65]);
			}
			else {
				if (order == '*') {
					tmp = stack.pop() * stack.pop();
					stack.push(tmp);
				}					
				else if (order == '+') {
					tmp = stack.pop() + stack.pop();
					stack.push(tmp);
				}					
				else if (order == '-') {
					sec_tmp = stack.pop();
					fir_tmp = stack.pop();
					tmp = fir_tmp - sec_tmp;
					stack.push(tmp);
				}
				else if (order == '/') {
					sec_tmp = stack.pop();
					fir_tmp = stack.pop();
					tmp = fir_tmp / sec_tmp;
					stack.push(tmp);
				}
			}
//			System.out.println(stack.peek());
		}
		
		sb.append(String.format("%.2f", stack.pop()));
		System.out.println(sb);
	}
}
