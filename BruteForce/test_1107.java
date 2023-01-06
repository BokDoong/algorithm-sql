package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1107 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int target = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		boolean[] broken = new boolean[10];
		if(n!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int btn = Integer.parseInt(st.nextToken());
				broken[btn] = true;
			}
		}
		
		//main
		int result = Math.abs(target-100);
		for(int i=0; i<1000000; i++) {
			String btn = String.valueOf(i);
			
			boolean check = true;
			int len = btn.length();
			for(int j=0; j<len; j++) {
				if(broken[btn.charAt(j)-'0']) {
					check = false;
					break;
				}
			}
			if(check)
				result = Math.min(result, Math.abs(target-i)+len);
		}
		
		//output
		System.out.println(result);
	}	
}
