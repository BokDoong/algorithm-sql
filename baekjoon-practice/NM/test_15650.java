package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_15650 {
	//1~N �� �ߺ����� M�� ����(0~8) + ��������
	static int[] a = new int[10];
	static StringBuilder sb = new StringBuilder();
	
	//idx�� � ä�������� Ȯ�� -> 0~m-1
	static void go(int idx, int start, int n, int m) {
		//�� �� ����(0~m-1)
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
