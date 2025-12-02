import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int K;
    static int[] scores;

    static int result = 0;

    static int calculateTotal() {
        
        int total = 0;
        
        for ( int n = 0 ; n < N ; n++ ) {
            total += scores[n];
        }
        
        return total;
        
    }

    static int calculateGroupCount(int target) {

        int k = 0;
        int total = 0;
        
        for ( int n = 0 ; n < N ; n++ ) {
            total += scores[n];
            if ( total >= target ) {
                total = 0;
                k += 1;
            }
        }

        return k;
        
    }
    
    static void solve() {

        int left = 0;
        int right = calculateTotal() + 1;
        int mid = right / 2;

        while ( left < right ) {

            mid = (left + right) / 2;
            int groupCount = calculateGroupCount(mid);

            if ( groupCount >= K ) {
                left = mid + 1;
            }
            else {
                right = mid; 
            }
            
        }

        result = left - 1;
        
    }

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        scores = new int[N];
        for ( int i = 0 ; i < N ; i++ ) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
    }

    static void output() {
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();
        output();
        
    }
    
}
