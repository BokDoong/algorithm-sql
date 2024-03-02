package dynamic_programming;
import java.util.*;
import java.io.*;

public class test_14002 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//최대 길이 수열
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
			
			//0~i의 이전 원소 탐색
			//이전의 j번째 원소가 i보다 작으면서도 dp[i]가 dp[j]+1보다 작을때 바꾼다
			for(int j=0; j<i; j++) {
				if(num[j]<num[i] && dp[i]<dp[j]+1)
					dp[i] = dp[j]+1;
			}
		}
		
		//최대 길이 순서의 순열에서 value 찾기
		//스택 => 뒤에서부터 최대 길이 수를 이용해 찾기 때문
		Stack<Integer> stack = new Stack<>();
		
		//dp의 최대값을 저장 => 다시 찾을 때를 위해
		int max_num = Arrays.stream(dp).max().getAsInt();
		int res = max_num;
		//찾기
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
