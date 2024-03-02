package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_1463 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//input -> [0]:0, [1]:0
		int n = Integer.parseInt(br.readLine());
		int [] dp = new int[n+1];
		dp[0]=0; dp[1]=0;
		
		//main
		for(int i=2; i<n+1; i++) {
			//-1 °ª, 2 ³ª´«°ª, 3 ³ª´«°ª
			int one = dp[i-1]; int two = Integer.MAX_VALUE; int three = Integer.MAX_VALUE;
			
			//two, three
			if(i%2==0)
				two = dp[i/2];
			if (i%3==0) 
				three = dp[i/3];
			
			//determination
			dp[i] = Math.min(one, Math.min(two, three));
			dp[i] += 1;
		}
		
		//output
		System.out.println(dp[n]);
	}
}
