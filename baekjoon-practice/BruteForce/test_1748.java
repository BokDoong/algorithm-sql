package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1748 {

	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		String n = br.readLine();
		
		//main
		//자릿수
		int result = 0;
		int pos = n.length();
		if(pos>1) {
			//이전 자리 수까지 합
			for(int i=1; i<pos; i++)
				result += i*9*Math.pow(10, i-1);
			
			//해당자리수
			result += pos*(Integer.parseInt(n)-Math.pow(10, pos-1)+1);
		}
		else
			result = Integer.parseInt(n);
		
		//output
		System.out.println(result);
	}	
}
