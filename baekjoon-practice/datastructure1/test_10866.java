package datastructure1;
import java.util.*;
import java.io.*;

public class test_10866 {
	public static void main(String args []) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> deque = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			
			switch(x) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(deque.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.getFirst()).append("\n");
				break;
			case "back":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.getLast()).append("\n");
				break;
			}	
		}
		System.out.println(sb);
	}
}
