package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public abstract class test_1476 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int E, S, M;
		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//main
		int e=1, s=1, m=1;
		int year=1;
		while(true) {
			if(e==E && s==S && m==M)
				break;
			
			e++; s++; m++;

			if(e==16)
				e = 1;
			if(s==29)
				s = 1;
			if(m==20)
				m = 1;
			
			year++;
		}
			
		//output
		System.out.println(year);
	}
}
