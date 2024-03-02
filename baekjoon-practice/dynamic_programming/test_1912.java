package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1912 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int [] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
				
		//dp
		int [] dp = new int[n];
		dp[0] = num[0];
		
		//main
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(num[i], dp[i-1]+num[i]);
		}
		
		//output
		int res = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			res = Math.max(res, dp[i]);
		System.out.println(res);
	}
}
