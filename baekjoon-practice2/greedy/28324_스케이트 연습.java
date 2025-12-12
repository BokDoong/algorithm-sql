import java.util.*;
import java.io.*;

class Main {

    static int N;
    static long[] velocities;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        
        velocities = new long[N];
        st = new StringTokenizer(br.readLine());
        for ( int i = 0 ; i < N ; i++ ) {
            velocities[i] = Long.parseLong(st.nextToken());
        }
        
    }

    static long solve() {

        long ans = 0L;
        long cur = 0L;

        for ( int i = N-1 ; i >= 0 ; i-- ) {
            cur = Math.min(velocities[i], cur + 1);
            ans += cur;
        }

        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }
    
}
