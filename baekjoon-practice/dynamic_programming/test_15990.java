package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_15990 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//num[i][1~3]: 각 수 조합이 1,2,3으로 끝나는 경우의 수
		long [][] num = new long [100_001][4];
		long [] res = new long [100001];
		res[1] = 1; res[2] = 1; res[3] = 3;
		
		//main
		//1로 끝나는 경우 -> i-1 수의 2,3으로 끝나는 경우의 수를 더함
		//2로 끝나는 경우 -> i-2 수의 1,3으로 끝나는 경우의 수를 더함
		//3으로 끝나는 경우 -> i-3 수의 1,2로 끝나는 경우의 수를 더함
		num[1][1] = 1; num[2][2] = 1;
		num[3][1] = 1; num[3][2] = 1; num[3][3] = 1;
		for(int i=4; i<100001; i++) {
			num[i][1] = (num[i-1][2] + num[i-1][3])%1_000_000_009;
			num[i][2] = (num[i-2][1] + num[i-2][3])%1_000_000_009;
			num[i][3] = (num[i-3][1] + num[i-3][2])%1_000_000_009;
			
			res[i] = (num[i][1] + num[i][2] + num[i][3])%1_000_000_009;
		}
		
		//input&output
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++)
			System.out.println(res[Integer.parseInt(br.readLine())]);
	}
}
