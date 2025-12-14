import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] P;
    static int[] S;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        P = new int[N];
        S = new int[N];

        st = new StringTokenizer(br.readLine());
        for ( int n = 0 ; n < N ; n++ ) {
            P[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for ( int n = 0 ; n < N ; n++ ) {
            S[n] = Integer.parseInt(st.nextToken());
        }
        
    }

    static int[] match;
    static int[] cards;

    static int result;

    static void initialize() {

        cards = new int[N];
        for ( int n = 0 ; n < N ; n++ ) {
            cards[n] = n;
        }

        result = 0;
        
    }

    static boolean isMatch() {
        
        for (int n = 0; n < N; n++) {
            
            if (P[cards[n]] != n % 3) {
                return false;
            }
            
        }
        
        return true;
    }
    
    static void shuffle() {
        
        int[] newCards = new int[N];
        
        for (int n = 0; n < N; n++) {
            newCards[S[n]] = cards[n];
        }
        
        cards = newCards;
        
    }
    
    static boolean cannotPlay() {
        
        for (int n = 0; n < N; n++) {
            if (cards[n] != n) {
                return false;
            }
        }
        
        return true;
        
    }
    
    static void play() {

        // 처음부터 같은지 확인 -> 0
        if ( isMatch() ) {
            return;
        }

        while ( true ) {

            // 섞끼
            shuffle();
            result += 1;

            // 매칭 확인
            if ( isMatch() ) {
                return;
            }

            // 초기랑 같은지 확인
            if ( cannotPlay() ) {
                result = -1;
                return;
            }
            
        }
        
    }


    public static void main(String[] args) throws IOException {

        input();
        initialize();
        play();
        System.out.println(result);
        
    }
    
}
