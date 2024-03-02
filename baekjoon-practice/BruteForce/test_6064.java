package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_6064 {

	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int n = Integer.parseInt(br.readLine());
		
		//main
		//M->x, N->y : �ֱ� M��ŭ x�� ���� ���� ����
		//x�� �������ѳ��� M�� �����ϸ� ������ y�� �˻�
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean check = false;
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			x -= 1; y -= 1;
			for(int k=x; k<(M*N); k+=M) {
				if(k%N == y) {
					System.out.println(k+1);
					check = true;
					break;
				}
			}
			if(!check)
				System.out.println(-1);
			
		}
		
		//output
	}
}
