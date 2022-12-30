package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_1932 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] inputs = br.readLine().split(" ");
			for(int j=0; j<inputs.length; j++)
				triangle[i][j] = Integer.parseInt(inputs[j]);
		}
		
		//dp
		int[][] dp = new int[n][n];
		dp[0][0] = triangle[0][0];
		
		//main
		//i=1~4, j=0~i
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0)
					dp[i][j] = triangle[i][j]+dp[i-1][j];
				else if(j==i)
					dp[i][j] = triangle[i][j]+dp[i-1][j-1];
				else {
					dp[i][j] = triangle[i][j]+Math.max(dp[i-1][j], dp[i-1][j-1]);
				}
			}
		}
		
		//output
		int result = 0;
		for(int i=0; i<dp[n-1].length; i++)
			result = Math.max(result, dp[n-1][i]);
		System.out.println(result);
	}
}
