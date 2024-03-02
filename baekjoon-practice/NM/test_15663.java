package NM;

import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedHashSet;

public class test_15663 {
	static int N;
	static int[] num;
	static boolean[] check;
	static int[] dfs_result;
	static LinkedHashSet<String> ans;
	
	public static void main(String args[]) {
		//input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		num = new int[N];
		dfs_result = new int[M];
		check = new boolean[N];
		ans = new LinkedHashSet<>();
		for(int i=0; i<N; i++)
			num[i] = sc.nextInt();
		
		//main
		Arrays.sort(num);
		dfs(0, M);
		
		//output
		ans.forEach(System.out::println);
	}
	
	public static void dfs(int idx, int m) {
		if(idx == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				sb.append(dfs_result[i]).append(' ');
			}
			//집합에 결과를 추가 -> 알아서 중복 제거됨.
			ans.add(sb.toString());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(check[i]==true)
				continue;
			
			check[i] = true;
			dfs_result[idx] = num[i];
			dfs(idx+1, m);
			check[i] = false;
		}
	}
}
