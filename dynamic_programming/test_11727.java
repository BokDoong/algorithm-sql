package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_11727 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		//0	3 5 11 21 
		int n = Integer.parseInt(br.readLine());
		int [] dp = new int[n+1];
		dp[0]=0; dp[1]=0; dp[2]=3; dp[3]=5;
		
		//main
		for(int i=4; i<n+1; i++)
			dp[i] = (2*dp[i-2]+dp[i-1])%10007;
		
		//output
		System.out.println(dp[n]%10007);
	}
}
