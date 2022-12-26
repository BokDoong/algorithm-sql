package datastructure1;
import java.util.*;
import java.io.*;

public class test_10845 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		Queue<Integer> queue = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int last = 0;
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			
			switch(x) {
			case "push":
				last = Integer.parseInt(st.nextToken());
				queue.offer(last);
				break;
			case "pop":
				if (!queue.isEmpty())
					sb.append(queue.poll()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if (queue.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.peek()).append("\n");
				break;
			case "back":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(last).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
		
	}
}
