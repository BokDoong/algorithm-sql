package datastructure1;
import java.io.*;
import java.util.*;

public class test_9012 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			sb.append(solve(br.readLine())).append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)=='(')
				stack.push(s.charAt(i));
			else if (stack.isEmpty())
				return "NO";
			else
				stack.pop();
		}
		
		if (stack.isEmpty())
			return "YES";
		else
			return "NO";
	}
}
