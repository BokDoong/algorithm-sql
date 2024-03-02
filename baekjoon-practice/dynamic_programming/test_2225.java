package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_2225 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//input
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//dp
		int [][] dp = new int[201][201];
		for(int i=1; i<201; i++)
			dp[1][i] = i;
		
		//main
		for(int i=2; i<201; i++) {
			for(int j=1; j<201; j++)
				dp[i][j] = dp[i-1][j]%1000000000 + dp[i][j-1]%1000000000;
		}
		
		//output
		System.out.println(dp[n][k]%1000000000);
	}
}
