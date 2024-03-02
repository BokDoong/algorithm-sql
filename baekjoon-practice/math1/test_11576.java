package math1;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_11576 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//setting
		int future = 0;
		//A,B����
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		//����
		int count = Integer.parseInt(br.readLine());
		//A������ ���� �ޱ�
		st = new StringTokenizer(br.readLine());
		List<Integer> alist = new ArrayList<>();
		for(int i=0; i<count; i++) {
			int n = Integer.parseInt(st.nextToken());
			alist.add(n);
		}
		
		//10���� ��ȯ
		int tmp = 1;
		int dec = 0;
		for(int i=count-1; i>=0; i--) {
			dec += alist.get(i)*tmp;
			tmp *= a;
		}
		
		//B���� ��ȯ
		Stack<Integer> stack = new Stack<>();
		while (dec>0) {
			stack.push(dec%b);
			dec /= b;
		}
		
		//���
		while(!stack.isEmpty()) {
			if(stack.size() == 1)
				System.out.println(stack.pop());
			else
				System.out.print(stack.pop() + " ");
		}
	}
}
