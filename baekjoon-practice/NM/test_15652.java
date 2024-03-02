package NM;

import java.util.*;

public class test_15652 {
	static int N;
	static int M;
	static int[] result = new int[10];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		dfs(0, 1);
		System.out.println(sb);
	}
	
	public static void dfs(int idx, int start) {
		//길이 다 차면
		if(idx == M) {
			//출력
			for(int i=0; i<M; i++) {
				sb.append(result[i]);
				if(i != M-1)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//아직 다 안차면
		for(int i=start; i<=N; i++) {
			
			result[idx]=i;
			dfs(idx+1, i);
		}
	}
}
