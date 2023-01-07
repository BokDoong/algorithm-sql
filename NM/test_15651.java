package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_15651 {
	static int[] a = new int [10];
	static StringBuilder sb = new StringBuilder();
	
	//1~N -> M개 선택, 중복 가능
	//idx로 M개까지 구했는지 아닌지 판단 -> idx:0~m-1
	static void go(int idx, int n, int m) {
		if(idx==m) {
			for(int i=0; i<m; i++) {
				sb.append(a[i]);
				if(i!=m-1)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			a[idx] = i;
			go(idx+1, n, m);
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//함수
		go(0, n, m);
		//출력
		System.out.println(sb);
	}
}
