package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_15988 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		
		//dp
		long [] dp = new long[1000001];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		
		//main
		for(int i=4; i<1000001; i++)
			dp[i] =(dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
		
		//output
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			System.out.println(dp[tmp]);
		}
	}
}
