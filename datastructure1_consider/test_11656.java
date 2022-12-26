package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_11656 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//input
		String word = br.readLine();
		int size = word.length();
		
		String [] res = new String[size];
		for(int i=0; i<size; i++) {
			res[i] = word.substring(i, size);
		}
		
		//Á¤·Ä
		Arrays.sort(res);
		
		//ouput
		for(int i=0; i<size; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb);
	}
}
