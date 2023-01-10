import java.util.Scanner;
import java.util.Arrays;

class Samsung2_DFS {
    static long N;
    static int x;
    static int y;
    static long max;
    static int len;
    static boolean check;
    static int[] target = new int[2];
    static int[] result;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=1; t<=T; t++) {
            N = sc.nextLong();
            x = sc.nextInt();
            y = sc.nextInt();
            len = String.valueOf(N).length();
            target[0] = x;
            target[1] = y;

            result = new int[len];
            check = false;
            max = -1;


            //두 자리수 이상
            if(len>=2) {
                //max 초기값을 len-1 자리수의 최대값 오게함.
                long tmp = 0;
                for (int i = 0; i < len - 1; i++)
                    tmp += Math.pow(10, i);
                max = y*tmp;
                //dfs
                dfs(0);
            }
            //한 자리수
            else {
                for(int i=1; i<=N; i++) {
                    if(i==x || i==y){
                        max = Math.max(max, i);
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }

    // && str.contains(String.valueOf(x)) && str.contains(String.valueOf(y))
    public static void dfs(int depth) {
        //깊이 다 차면 대소비교 + return
        if(depth == len) {
            String str = Arrays.toString(result).replaceAll("[^0-9]","");
//            System.out.println(str);
            if(Long.parseLong(str) <= N) {
                max = Math.max(max, Long.parseLong(str));
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