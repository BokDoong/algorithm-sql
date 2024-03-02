package math1;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�ƽ�Ű �ڵ�: A~Z(65~90), a~z(97~122)
//���ڷ� �ްԵǴ� �ƽ�Ű�ڵ� �̿� 
public class test_2745 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		int i, tmp = 1;
		String n = st.nextToken();
		int x = Integer.parseInt(st.nextToken());
		
		for (i=n.length()-1; i>=0; i--) {
			char c = n.charAt(i);
			if ('A' <= c && c <= 'Z') {
				result += (c - 'A' + 10) * tmp;
			}
			else {
				result += (c - '0') * tmp;
			}
			tmp *= x;
		}
		System.out.println(result);
	}
}
