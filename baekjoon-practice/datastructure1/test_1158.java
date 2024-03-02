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
		
		//1~n ť ����
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=1; i<=n; i++)
			queue.offer(i);
		
		//main
		int tmp = k-1;
		while (queue.size() > 1) {
			//k-1�� ���� ť�� peek���� �� �ڷ� ����
			for(int i=0; i<tmp; i++)
				queue.offer(queue.poll());
			//k-1�� ������ ���� peek ���� ��� sb�� ����
			sb.append(queue.poll()).append(", ");
		}
		//������ �ϳ� ���� �� ����� �߰�
		sb.append(queue.poll()).append(">");
		
		//���
		System.out.println(sb);
	}
}
