package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_15651 {
	static int[] a = new int [10];
	static StringBuilder sb = new StringBuilder();
	
	//1~N -> M�� ����, �ߺ� ����
	//idx�� M������ ���ߴ��� �ƴ��� �Ǵ� -> idx:0~m-1
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
		
		//�Լ�
		go(0, n, m);
		//���
		System.out.println(sb);
	}
}
