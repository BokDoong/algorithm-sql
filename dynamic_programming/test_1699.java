package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1699 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		
		//dp
		int [] dp = new int[n+1];
		for(int i=1; i<n+1; i++)
			dp[i] = i;
		
		//main
		for(int i=2; i<n+1; i++){
			for(int j=1; j*j<=i; j++) {
				int tmp = j*j;
				dp[i] = Math.min(1+dp[i-tmp], dp[i]);
			}
		}
			
		//output
		System.out.println(dp[n]);
	}
}
