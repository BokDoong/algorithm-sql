package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_11655 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine();
		int len = word.length();
		
		//a~z : 97~122
		//A~Z : 65~90
		for(int i=0; i<len; i++) {
			char order = word.charAt(i);
			if (order == ' ')
				sb.append(' ');
			else if (order >= 'A' && order <= 'Z') {
				int tmp = (int)order+13;
				if (tmp <= 90)
					sb.append((char)tmp);
				else
					sb.append((char)(64+tmp%90));
			}
			else if (order >= 'a' && order <= 'z') {
				int tmp = (int)order+13;
				if (tmp <= 122)
					sb.append((char)tmp);
				else
					sb.append((char)(96+tmp%122));
			}
			else
				sb.append(order);
		}
		
		System.out.println(sb);
	}
}
