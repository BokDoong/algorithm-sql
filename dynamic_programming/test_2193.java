package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_2193 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int N = Integer.parseInt(br.readLine());
		//결과값 담는 배열
		long [] result = new long[N+1];
		result[0] = 0; result[1] = 1;

		//main
		//num[i][0] = num[i-1][0]+num[i-1][1] = num[i-1]
	    //num[i][1] = num[i-1][0] = num[i-2]
		for(int i=2; i<N+1; i++) 
			result[i] = result[i-1]+result[i-2];
		
		//output
		System.out.println(result[N]);
	}
}