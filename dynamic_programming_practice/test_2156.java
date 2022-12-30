package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_2156 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//설명
		//oox : dp[i-1] - 이전의 제일 큰 값
		//xoo : wines[i]+wines[i-1]+dp[i-3](xoo 이전의 제일 큰 값)
		//oxo : wine[i]+dp[i-2]
		
		//input
		int n = Integer.parseInt(br.readLine());
		
		int[] wines = new int[n+1];
		for(int i=1; i<n+1; i++)
			wines[i] = Integer.parseInt(br.readLine());
		
		//dp
		int[] dp = new int[n+1];
		dp[1] = wines[1];
		
		//main
		for(int i=2; i<n+1; i++) {
			if(i==2) {
				dp[2] = dp[1]+wines[2];
				continue;
			}			
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+wines[i-1]+wines[i], dp[i-2]+wines[i]));
		}
		
		//output
		System.out.println(dp[n]);
	}
}
