import java.util.Scanner;
import java.util.Arrays;

public class Samsung2 {
    static int N;
    static int x;
    static int y;
    static int max;
    static int len;
    static boolean check;
    static int[] target = new int[2];
    static int[] result;

    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=1; t<=T; t++) {
            N = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            len = String.valueOf(N).length();
            target[0] = x;
            target[1] = y;

            result = new int[len];
            check = false;
            max = 0;


            //세 자리수 이상
            if(len>2) {
                //max의 초기값을 len-1 자리수의 최대값 오게함.
                int tmp = 0;
                for (int i=0; i<len-1; i++) {
                    tmp += Math.pow(10, i);
                }
                max = y*tmp;
                //System.out.println(max);
 //                 for (int i = 0; i < len - 2; i++)
//                   tmp += Math.pow(10, i);
//                max = x + y * (tmp * 10);
//                System.out.println(max);
                //dfs
                dfs(0);
            }
            //두 자리수
            else if(len == 2){
                //max의 초기값을 y로 설정
                max = y;
                //dfs
                dfs(0);
            }
            //일의자리수
            else {
                dfs(0);
                if(max==0)
                    max = -1;
            }

            System.out.println("#" + t + " " + max);
        }
    }

    // && str.contains(String.valueOf(x)) && str.contains(String.valueOf(y))
    public static void dfs(int depth) {
        //깊이 다 차면 대소비교 + return
        if(depth == len) {
            String str = Arrays.toString(result).replaceAll("[^0-9]","");
            if(Integer.parseInt(str) <= N) {
                max = Math.max(max, Integer.parseInt(str));
            }
            //System.out.println(max);
            return;
        }

        //백트래킹
        for(int i=0; i<2; i++) {
            result[depth] = target[i];
            dfs(depth+1);
        }
    }
}
