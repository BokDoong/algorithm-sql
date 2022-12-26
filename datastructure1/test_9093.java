package datastructure1;
import java.util.*;
import java.io.*;

public class test_9093 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			String input = br.readLine();
			input += "\n";
			
			StringBuilder sb = new StringBuilder("");
			for (int j=0; j<input.length(); j++) {
				if (input.charAt(j) == ' ' || input.charAt(j) == '\n') {
					while (!stack.isEmpty()) {
						sb.append(stack.peek());
						stack.pop();
					}
					if (input.charAt(j) == ' ') {
						sb.append(input.charAt(j));
					}
				}
				else {
					stack.push(input.charAt(j));
				}
			}
			bw.write(sb.toString() + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
