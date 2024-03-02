package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_14002 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//�ִ� ���� ����
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
		
		//�ִ� ���� ������ �������� value ã��
		//���� => �ڿ������� �ִ� ���� ���� �̿��� ã�� ����
		Stack<Integer> stack = new Stack<>();
		
		//dp�� �ִ밪�� ���� => �ٽ� ã�� ���� ����
		int max_num = Arrays.stream(dp).max().getAsInt();
		int res = max_num;
		//ã��
		for(int i=N-1; i>=0; i--) {
			if(max_num == dp[i]) {
				stack.push(num[i]);
				max_num--;
			}
		}
		
		//output
		while(!stack.isEmpty())
			sb.append(stack.pop()).append(" ");
		
		System.out.println(res);
		System.out.println(sb);
	}
}
