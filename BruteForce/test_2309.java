package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test_2309 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int[] shorts = new int[9];
		for(int i=0; i<9; i++) {
			shorts[i] = Integer.parseInt(br.readLine());
		}
		
		//main
		//9명 모든 합 구해놓기
		int total=0;
		for(int i=0; i<9; i++)
			total += shorts[i];
		
		//정렬
		Arrays.sort(shorts);
		
		//반복문 돌리며 2명씩 빼보기
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(total-shorts[i]-shorts[j] == 100) {
					for(int k=0; k<9; k++) {
						if(i==k || j==k)
							continue;
						else
							System.out.println(shorts[k]);
					}
					System.exit(0);;
				}
			}
		}
		
		
		//output
	}
}
