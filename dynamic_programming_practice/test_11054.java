package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_11054 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int[] test = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			test[i] = Integer.parseInt(st.nextToken());
			
		//앞 dp
		int[] dp = new int[n];
		dp[0] = 1;

		for(int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<=i; j++) {
				if(test[j]<test[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		
		//거꾸로
		int[] reverse_test = new int[n];
		for(int i=0; i<n; i++)
			reverse_test[i] = test[n-1-i];
		
		//뒤 dp
		int[] dp2 = new int [n];
		dp2[0] = 1;
		for(int i=1; i<n; i++) {
			dp2[i] = 1;
			for(int j=0; j<=i; j++) {
				if(reverse_test[j]<reverse_test[i]) {
					dp2[i] = Math.max(dp2[j]+1, dp2[i]);
				}
			}
		}
	
		//dp2거꾸로
		int[] result_dp2 = new int[n];
		for(int i=0; i<n; i++)
			result_dp2[i] = dp2[n-1-i];
			
		//Output
		int[] result = new int [n];
		for(int i=0; i<n; i++) {
			result[i] = dp[i]+result_dp2[i]-1;
		}
		
		//답
		int max_result=0;
		for(int i=0; i<n; i++)
			max_result = Math.max(max_result, result[i]);
		System.out.print(max_result);
	}
}
