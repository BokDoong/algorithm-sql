package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_10844 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long [][] num = new long[101][10];
		long [] res = new long [101];
		//자릿수가 1일 때 설정
		for(int i=1; i<10; i++)
			num[1][i] = 1;
		res[1] = 9;
		
		//두 자릿수부터~
		for(int i=2; i<101; i++) {
			for(int n=0; n<10; n++) {
				if(n==0)
					num[i][n] = (num[i-1][1])%1_000_000_000L;
				else if(n==9)
					num[i][n] = (num[i-1][8])%1_000_000_000L;
				else
					num[i][n] = (num[i-1][n-1]%1_000_000_000L + num[i-1][n+1]%1_000_000_000L)%1_000_000_000L;
			}
			
			for(int j=0; j<10; j++)
				res[i] += (num[i][j])%1_000_000_000L;
		}
		
		//output
		int result = Integer.parseInt(br.readLine());
		System.out.println(res[result]);
	}
}
