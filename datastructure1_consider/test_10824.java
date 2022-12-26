package datastructure1_consider;
import java.util.*;
import java.io.*;

public class test_10824 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String [] word = new String[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			word[i] = st.nextToken();
		}
		
		String tmp1 = word[0]+word[1];
		String tmp2 = word[2]+word[3];
		System.out.println(Integer.parseInt(tmp1) + Integer.parseInt(tmp2));
	}
}
