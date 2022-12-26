package math1;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_11653 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		//소인수분해 언제까지해도 제곱근이상 나눠지지 않음을 활용
		for(int i=2; i<=Math.sqrt(num); i++) {
			while (num%i == 0) {
				System.out.println(i);
				num /= i;
			}
		}
		
		if (num != 1) {
			System.out.println(num);
		}
	}
}