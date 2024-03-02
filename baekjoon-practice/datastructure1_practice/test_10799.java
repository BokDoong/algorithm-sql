package datastructure1_practice;
import java.util.*;
import java.io.*;

public class test_10799 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//input
		String stick = br.readLine();
		
		//stick -> queue
		Queue<Character> queue = new LinkedList<>();
		for(int i=0; i<stick.length(); i++)
			queue.offer(stick.charAt(i));
		
		//main
		// "(" -> ���� ")"�� ������ �����ִ� ��ƽ���� cnt�� result�� ���Ѵ�.
		// "(" -> ���� "(" ���ð��� += 1
		//")" -> ���ð��� cnt -= 1
		int result = 0, cnt = 0, tmp = 0;
		while(!queue.isEmpty()) {
			tmp = queue.poll();
			if(tmp == '(') {
				if(queue.peek() == ')') {
					result += cnt;
					queue.poll();
				}
				else if(queue.peek() == '(') {
					cnt += 1;
					result += 1;
				}					
			}
			else {
				cnt -= 1;
			}
		}
		System.out.println(result);
	}
}
