package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_11726 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		int [] dp = new int[n+1];
		dp[0]=1; dp[1]=1;
		
		//main
		for(int i=2; i<n+1; i++)
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		
		//output
		System.out.println(dp[n]%10007);
	}
}
