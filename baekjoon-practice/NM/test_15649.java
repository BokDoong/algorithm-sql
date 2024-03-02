package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//n 중에서 m개 중복없이 택하기
public class test_15649 {
	//c의 idx 중 false(아직 안들어감) 되어있는 것들을 a에 집어넣자.
	static boolean[] c = new boolean[10];
	static int[] a = new int[10];
	static StringBuilder sb = new StringBuilder();
	
	//재귀 + 메소드
	static void go(int idx, int n, int m) {
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
		for(int i=1; i<=n; i++) {
			//true : 이미 택한거면 패스
			if(c[i])
				continue;
			//false : 선택 안되어있다 -> 넣어야함
			c[i] = true;
			a[idx] = i;
			go(idx+1, n, m);
			//끝났으면 -> 다시 false로 초기화
			c[i] = false;
		}
	}
	
	//메인
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		go(0, n, m);
		System.out.println(sb.toString());
	}
}
