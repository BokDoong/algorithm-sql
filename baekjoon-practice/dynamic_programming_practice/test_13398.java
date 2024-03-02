package dynamic_programming_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_13398 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int [] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
				
		//dp
		int [][] dp = new int[2][n];
		dp[0][0] = num[0];
		for(int i=0; i<2; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j] = num[j];
			}
		}
		//main
		//������ ��
		for(int i=1; i<n; i++) {
			//����x
			dp[0][i] = Math.max(num[i], dp[0][i-1]+num[i]);
			//����o
			//dp[0][i-1]:i��° ���� ������ ��, dp[1][i-1]: ���� ������ ���� �ִ밪
			dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]+num[i]);
		}
		
		//output
		int res1 = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			res1 = Math.max(res1, dp[0][i]);
		
		int res2 = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			res2 = Math.max(res2, dp[1][i]);
		
		System.out.println(Math.max(res1, res2));
	}
}
