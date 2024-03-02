package math1;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//아스키 코드: A~Z(65~90), a~z(97~122)
//아스키코드 변환: (char)num
public class test_11005{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int num = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		List<Character> result = new ArrayList<>();
		
		while(num>0) {			
			//소인수 분해 + 아스키 코드 변환
			int tmp = num%x;
			if (tmp>=10) {
				//tmp +'A' : 대문자 A의 정수만큼 더해서 추가
				result.add((char)(tmp -10 + 'A'));
			}
			else {
				result.add((char)(tmp + '0'));
			}
			num /= x;
		}
		for(int i=result.size()-1; i>=0; i--) {
			System.out.print(result.get(i));
		}
	}
}
