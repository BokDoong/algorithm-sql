package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_11053 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//init
		int N = Integer.parseInt(br.readLine());
		int [] num = new int [N];
		int [] dp = new int [N];
		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		//main
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			
			//0~i�� ���� ���� Ž��
			//������ j��° ���Ұ� i���� �����鼭�� dp[i]�� dp[j]+1���� ������ �ٲ۴�
			for(int j=0; j<i; j++) {
				if(num[j]<num[i] && dp[i]<dp[j]+1)
					dp[i] = dp[j]+1;
			}
		}
		
		//output
		//System.out.println("�ִ밪 : " + Arrays.stream(arr).max().getAsInt());
		System.out.println(Arrays.stream(dp).max().getAsInt());
		for(int i=0; i<dp.length; i++)
			System.out.print(dp[i] + " ");
	}
}
