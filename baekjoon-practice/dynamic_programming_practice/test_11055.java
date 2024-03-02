package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_11055 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int[] test = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			test[i] = Integer.parseInt(st.nextToken());
			
		//dp
		//dp�� �� �ڸ��� �� �ڸ��� �κ� ���� �� ��������
		int[] dp = new int[n];
		dp[0] = test[0];
		
		//main
		for(int i=1; i<n; i++) {
			dp[i] = test[i];
			for(int j=0; j<=i; j++) {
				if(test[i]>test[j]) {
					dp[i] = Math.max(dp[i], dp[j]+test[i]);
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
