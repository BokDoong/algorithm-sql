package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_11052 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int [] card = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++)
			card[i] = Integer.parseInt(st.nextToken());
		
		//dp
		int [] dp = new int[n+1];
		//0장, 1장
		dp[0] = card[0]; dp[1] = card[1];
		
		//main : 1장 ~ n장 일 때의 최대 가격 하나씩 구하기
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<i; j++) {
				dp[i] = Math.max(dp[j]+card[i-j],dp[i]);
			}
		}
		
		//output
		System.out.println(dp[n]);
	}
}
