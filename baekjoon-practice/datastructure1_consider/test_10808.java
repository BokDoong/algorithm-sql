package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_10808 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//a~z : 97~122
		int [] result = new int[26];
		String word = br.readLine();
		
		//main
		for (int i=0; i<word.length(); i++)
			result[(int)word.charAt(i)-97] += 1;
		
		//output
		for (int i=0; i<26; i++)
			sb.append(result[i]).append(' ');
		System.out.println(sb);
	}
}
