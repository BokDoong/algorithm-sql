package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_10820 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = "";
		
		while((word = br.readLine()) != null) {
			StringBuilder sb = new StringBuilder();
			
			//main
			int [] result = new int[4];
			
			for (int i=0; i<word.length(); i++) {
				char tmp = word.charAt(i);
				if (tmp >= 'a' && tmp <= 'z')
					result[0] += 1;
				else if (tmp >= 'A' && tmp <= 'Z')
					result[1] += 1;
				else if (tmp >= '0' && tmp <= '9')
					result[2] += 1;
				else if (tmp == ' ')
					result[3] += 1;
			}
			
			//output
			for(int i=0; i<4; i++)
				sb.append(result[i]).append(" ");
			System.out.println(sb);
		}
	}
}
