package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1107 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int target = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<cnt; i++)
			broken[Integer.parseInt(st.nextToken())] = true;
			
		//main
		int result = Math.abs(target - 100);
		//10으로 나누고 나머지를 구해 고장난버튼인지 검사
		for(int i=0; i<1000000; i++) {
			String str = String.valueOf(i);
			
			boolean isBreak = false;
			for(int j=0; j<str.length(); j++) {
				if(broken[str.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			
			if(!isBreak) {
				int min = Math.abs(target - i) + str.length();
				result = Math.min(min, result);
			}
		}
		
		//output
		System.out.println(result);
	}
}
