package datastructure1;

import java.util.*;
import java.io.*;

public class test_1158 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//n, k
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//1~n 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=1; i<=n; i++)
			queue.offer(i);
		
		//main
		int tmp = k-1;
		while (queue.size() > 1) {
			//k-1번 동안 큐의 peek값을 맨 뒤로 보냄
			for(int i=0; i<tmp; i++)
				queue.offer(queue.poll());
			//k-1번 실행한 후의 peek 값을 결과 sb에 저장
			sb.append(queue.poll()).append(", ");
		}
		//마지막 하나 남은 값 결과에 추가
		sb.append(queue.poll()).append(">");
		
		//출력
		System.out.println(sb);
	}
}
