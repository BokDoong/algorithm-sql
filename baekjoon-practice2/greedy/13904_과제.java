import java.io.*;
import java.util.*;

class Main {

    static int[] scores = new int[1001];

    static int N;
    static int[][] works;

    static int maxDate = -1;
    static int result;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        works = new int[N][2];

        for ( int i = 0 ; i < N ; i++ ) {
            
            st = new StringTokenizer(br.readLine());
            
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
            
        }
        
    }

    static void solve() {

        // 점수 기준으로 정렬
        Arrays.sort(works, Comparator.comparingInt((int[] w) -> -w[1]));

        // 하나씩 배치
        for ( int d = 1 ; d < N+1 ; d++ ) {
            
            // 날짜, 점수, 최대 날짜
            int day = works[d-1][0];
            int score = works[d-1][1];
            maxDate = Math.max(maxDate, day);

            // 해당 자리에 넣기
            if ( scores[day] == 0 ) {
                scores[day] = score;
            }
            else {

                // 없으면 가장 가까운 자리에
                for ( int r = day-1 ; r > 0 ; r-- ) {
                    if ( scores[r] == 0 ) {
                        scores[r] = score;
                        break;
                    }
                }
                
            }
            
        }
        
    }

    static void caculateResult() {

        for ( int i = 1 ; i <= maxDate ; i++ ) {
            result = result + scores[i];
        }
        
    }
    
    public static void main(String[] args) throws IOException {

        input();
        solve();
        caculateResult();
        System.out.println(result);
        
    }
    
}
