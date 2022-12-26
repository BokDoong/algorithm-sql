package math1;
import java.util.*;
import java.io.*;

public class Code_Test {	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//선언 및 입력
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> tree = new TreeSet<>();
		int [] height = new int[N];		//각 노드 높이
		long result = 0;					//결과값
		
		//main
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(tree.higher(num) == null) {
				if(tree.lower(num) == null)
					height[num] = 1;
				else
					height[num] = height[tree.lower(num)]+1;
			}
			else {
				if(tree.lower(num) == null)
					height[num] = height[tree.higher(num)]+1;
				else
					height[num] = Math.max(height[tree.higher(num)], height[tree.lower(num)])+1;
			}
			
			result += height[num];
			tree.add(num);
		}
		
		//output
		System.out.println(result);
	}
}
