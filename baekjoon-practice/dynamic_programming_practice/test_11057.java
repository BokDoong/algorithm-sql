package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_11057 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		
		//dp
		int [][] dp = new int[n+1][10];
		for(int i=0; i<10; i++)
			dp[1][i] = 1;
		
		//main
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<=j; k++)
					dp[i][j] += dp[i-1][k]%10007;
			}
		}
		
		//output
		int result = 0;
		for(int i=0; i<10; i++)
			result += dp[n][i];
		System.out.println(result%10007);
	}	
}
