package NM;

import java.util.Arrays;
import java.util.Scanner;

public class test_15655 {
	static int N;
	static int M;
	static int[] num;
	static int[] result = new int[10];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) {
		//input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		//main
		Arrays.sort(num);
		dfs(0, 0);
		
		//output
		System.out.println(sb);
	}
	
	public static void dfs(int idx, int start) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]);
				if(i!=M-1)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[idx]=num[i];
			dfs(idx+1, i+1);			
		}
	}
}
