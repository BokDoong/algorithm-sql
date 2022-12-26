package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_9095 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//main
		int [] dp = new int[11];
		dp[0]=0; dp[1]=1; dp[2]=2; dp[3]=4;
		for(int i=4; i<11; i++)
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		
		//input&output
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			System.out.println(dp[tmp]);
		}
	}
}
