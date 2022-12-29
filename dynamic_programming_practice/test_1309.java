package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1309 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		
		//dp
		int [] dp = new int[n+1];
		dp[0] = 1; dp[1] = 3;
		
		//main
		for(int i=2; i<n+1; i++)
			dp[i] = dp[i-1]*2+dp[i-2];
		
		//output
		System.out.println(dp[n]);
	}	
}
