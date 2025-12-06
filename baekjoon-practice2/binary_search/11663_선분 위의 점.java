import java.util.*;
import java.io.*;

class Main {

    static int N, M; 
    static int[] vectors;
    static int[][] lines;

    static Set<Integer> vectorSet = new HashSet<>();

    static StringBuilder answer = new StringBuilder();

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vectors = new int[N];
        st = new StringTokenizer(br.readLine());
        for ( int i = 0 ; i < N ; i++ ) {
            int vector = Integer.parseInt(st.nextToken());
            vectorSet.add(vector);
            vectors[i] = vector;
        }

        lines = new int[M][2];
        for ( int i = 0 ; i < M ; i++ ) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }
        
    }

    static int searchIndex(int target) {

        // 안에 있는 수인지 확인
        boolean isIn = false;
        if ( vectorSet.contains(target) ) {
            isIn = true;
        }
        
        // 인덱스 탐색
        int left = 0;
        int right = N;
        int mid = (left + right) / 2;

        while ( left < right ) {

            mid = (left + right) / 2;

            if ( vectors[mid] < target ) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
            
        }

        // 이미 있는 수이면 그대로 리턴, 아니라면 -1
        if ( isIn ) {
            return left;
        }
        else {
             return left - 1;   
        }
        
    }

    static void solve() {

        // 정렬
        Arrays.sort(vectors);

        // 하나씩 찾아서 출력
        for ( int m = 0 ; m < M ; m++ ) {
            
            int start = lines[m][0];
            int end = lines[m][1];

            int idx = searchIndex(end) - searchIndex(start);
            if ( vectorSet.contains(start) ) {
                idx += 1;
            }

            answer.append(idx).append("\n");
                
        }
        
    }
    
    public static void main(String[] args) throws IOException {

        input();
        solve();
        System.out.println(answer);

    }
    
}
