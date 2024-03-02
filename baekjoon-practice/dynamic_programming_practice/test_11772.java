package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_11772 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int[] test = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			test[i] = Integer.parseInt(st.nextToken());
			
		//dp
		//dp의 각 자리에 각 자리에 1을 넣는다
		int[] dp = new int[n];
		dp[0] = 1;
		
		//main
		for(int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<=i; j++) {
				if(test[i]<test[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		
		//output
		int result = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			result = Math.max(result, dp[i]);
		System.out.println(result);
	}
}
