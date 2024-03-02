import java.util.Scanner;

public class Samsung2_Greedy {
    static String string_N;
    static int[] N;
    static int x;
    static int y;
    static int len;
    static int[] result;
    static StringBuilder sb;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=1; t<=T; t++) {
            //StringBuilder
            sb = new StringBuilder();
            //N
            string_N = sc.next();
            N = new int[string_N.length()];
            for(int i=0; i<N.length; i++)
                N[i] = string_N.charAt(i) - '0';
            //x,y
            x = sc.nextInt(); y = sc.nextInt();
            //N의 길이
            len = N.length;
            //결과값 담을 문자열 -> 길이 : len
            result = new int[len];

            int cnt = 0;
            while(cnt<len) {
                int pos = N[cnt];

                //자리수가 y보다 클때 - clear
                if(pos > y) {
                    for(; cnt<len; cnt++)
                        result[cnt] = y;
                    break;
                }
                //자리수가 y랑 같을 때
                else if(pos == y){
                    result[cnt] = y;
                }
                //자리수가 x~y 사이에 있을 때
                else if(pos>x && pos<y) {
                    result[cnt] = x;
                    for(cnt=cnt+1 ; cnt<len; cnt++)
                        result[cnt] = y;
                }
                //자리수가 x랑 같을 때
                else if(pos == x) {
                    result[cnt] = x;
                }
                //자리수가 x보다 작을 때
                else {
                    //첫 번쨰 오는 수의 경우
                    if(cnt == 0) {
                        result[0] = 0;
                        for(cnt=1; cnt<len; cnt++)
                            result[cnt] = y;
                    }
                    //다른 때일 때
                    else {
                        //그 앞의 수가 y보다 클 때
                        if(result[cnt-1]>y) {
                            result[cnt-1] = y;
                            for (; cnt < len; cnt++)
                                result[cnt] = y;
                        }
                        //그 앞의 수가 x보다 크고 y보다 작거나 같을 때
                        else if(result[cnt-1]<=y && result[cnt-1]>x) {
                            result[cnt-1] = x;
                            for (; cnt < len; cnt++)
                                result[cnt] = y;
                        }
                        //그 앞의 수가 x보다 작을 때
                        else {
                            N[cnt-1] = pos;
                            cnt -= 2;
                        }
                    }
                }
                cnt++;
            }

            //출력
            if(result[0] == 0) {
                if(result.length == 1)
                    sb.append(-1);
                else {
                    for (int i = 1; i < result.length; i++) {
                        sb.append(result[i]);
                    }
                }
            }
            else {
                for (int i = 0; i < result.length; i++) {
                    sb.append(result[i]);
                }
            }

            System.out.println("#" + t + " " + sb);
        }
    }
}
