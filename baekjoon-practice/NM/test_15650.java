package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_15650 {
	//1~N 중 중복없이 M개 선택(0~8) + 오름차순
	static int[] a = new int[10];
	static StringBuilder sb = new StringBuilder();
	
	//idx로 몇개 채워졌는지 확인 -> 0~m-1
	static void go(int idx, int start, int n, int m) {
		//다 들어간 상태(0~m-1)
		if(idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(a[i]);
				if(i != m-1)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//main
		for(int i=start; i<=n; i++) {
			a[idx] = i;
			go(idx+1, i+1, n, m);
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		go(0, 1, n, m);
		System.out.println(sb);
	}
}
