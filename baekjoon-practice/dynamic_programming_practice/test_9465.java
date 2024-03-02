package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_9465 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		
		//main
		for(int i=0; i<n; i++) {
			//dp
			int len = Integer.parseInt(br.readLine());
			
			int [][] stk = new int [2][len+1];
			int [][] dp = new int [2][len+1];
			
			for(int j=0; j<2; j++) {
				String[] inputs = br.readLine().split(" ");
				for(int k=1; k<len+1; k++)
					stk[j][k] = Integer.parseInt(inputs[k-1]);
			}
			
			//main
			dp[0][1] = stk[0][1]; dp[1][1] = stk[1][1];
			for(int t=2; t<len+1; t++) {
				dp[0][t] = stk[0][t] + Math.max(dp[1][t-1], dp[1][t-2]);
				dp[1][t] = stk[1][t] + Math.max(dp[0][t-1], dp[0][t-2]);
			}
			
			//output
			System.out.println(Math.max(dp[0][len], dp[1][len]));
		}
	}
}
