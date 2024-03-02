package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_10809 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//a~z : 97~122
		//처음 등장하는 위치 찾기
		int [] result = new int[26];
		for(int i=0; i<26; i++)
			result[i] = -1;
		String word = br.readLine();
		
		for(int i=0; i<26; i++) {
			result[i] = word.indexOf((char)(i+97));
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
