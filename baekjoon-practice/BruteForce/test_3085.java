package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_3085 {
	public static int N;
	public static Character[][] candy;
	public static int max = 0;
	
	//행, 열마다의 중복최대값 찾기
	public static void FindMax() {
		//행에서의 중복 최대값
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=0; j<N-1; j++) {
				if(candy[i][j]==candy[i][j+1])
					cnt+=1;
				else
					cnt=1;
				max = Math.max(max, cnt);
			}
		}
		
		//열에서의 중복 최대값
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=0; j<N-1; j++) {
				if(candy[j][i]==candy[j+1][i])
					cnt+=1;
				else
					cnt=1;
				max = Math.max(max, cnt);
			}
		}
	}
	
	//메인
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		N = Integer.parseInt(br.readLine());
		candy = new Character[N][N];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++)
				candy[i][j] = tmp.charAt(j);
		}
			
			
		//main
		//행&열 바꾸기(오른쪽, 아래쪽)
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//행
				if(j<N-1) {
					//swap
					char temp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = temp;
					//최대 중복개수 비교해보기
					FindMax();
					//돌려놓기
					temp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = temp;
				}
				
				//열
				if(i<N-1) {
					//swap
					char temp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = temp;
					//최대중복개수 비교해보기
					FindMax();
					//돌려놓기
					temp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = temp;
				}
			}
		}
		
		//output
		System.out.println(max);
	}

}
