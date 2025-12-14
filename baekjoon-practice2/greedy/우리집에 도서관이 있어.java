import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] nums;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for ( int n = 0 ; n < N ; n++ ) {
            st = new StringTokenizer(br.readLine());
            nums[n] = Integer.parseInt(st.nextToken());
        }
        
    }

    static int result = 0;

    static void solve() {

        int target = N;

        for ( int n = N-1 ; n >= 0 ; n-- ) {

            if ( nums[n] == target ) {
                target -= 1;
            } else {
                result += 1;
            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {

        input();
        solve();
        System.out.println(result);
        
    }
    
}
