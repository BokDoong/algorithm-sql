package NM;

import java.util.Arrays;
import java.util.Scanner;

public class test_15657 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] num;
	static int[] result;
	
	public static void main(String args[]) {
		//input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		num = new int[N];
		result = new int[M];
		for(int i=0; i<N; i++)
			num[i] = sc.nextInt();
		
		//main
		Arrays.sort(num);
		dfs(0, M, 0);
		
		//output
		System.out.println(sb);
	}
	
	public static void dfs(int idx, int m, int start) {
		if(idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(result[i]);
				if(i!=m-1)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[idx] = num[i];
			dfs(idx+1, m, i);
		}
	}
}
