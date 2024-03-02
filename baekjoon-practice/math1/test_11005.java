package math1;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�ƽ�Ű �ڵ�: A~Z(65~90), a~z(97~122)
//�ƽ�Ű�ڵ� ��ȯ: (char)num
public class test_11005{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int num = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		List<Character> result = new ArrayList<>();
		
		while(num>0) {			
			//���μ� ���� + �ƽ�Ű �ڵ� ��ȯ
			int tmp = num%x;
			if (tmp>=10) {
				//tmp +'A' : �빮�� A�� ������ŭ ���ؼ� �߰�
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
