import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] dols;

    static List<Integer> result = new ArrayList<>();
    static int resultHeight;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dols = new int[N][4];
        for ( int i = 0 ; i < N ; i++ ) {
            st = new StringTokenizer(br.readLine());
            dols[i][0] = Integer.parseInt(st.nextToken());
            dols[i][1] = Integer.parseInt(st.nextToken());
            dols[i][2] = Integer.parseInt(st.nextToken());
            dols[i][3] = i + 1;
        }
        
    }

    static void sortDols() {
        Arrays.sort(dols, Comparator.comparingInt(dols -> -dols[0]));
    }

    static void updateResult(Stack<Integer> stack, int height) {
        resultHeight = height;
        result = new ArrayList<>(stack);
    }

    static void backTracking(int nowIdx, Stack<Integer> stack, int height) {

        // 높이 체크해서 결과 업뎃
        if ( height > resultHeight ) {
            updateResult(stack, height);
        }

        // 비어있거나 무게가 적다면 ㄱㄱ
        for (int i = nowIdx; i < N; i++) {
            if (stack.isEmpty() || dols[stack.peek()][2] > dols[i][2]) {
                stack.push(i);
                backTracking(i + 1, stack, height + dols[i][1]);
                stack.pop();
            }
        }
            
    }

    static void dp() {

        int[] DP = new int[N];
        
        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        // 초기화
        for ( int n = 0 ; n < N ; n++ ) {
            DP[n] = dols[n][1];
        }

        // DP
        for ( int n = 0 ; n < N ; n++ ) {
            for ( int m = 0 ; m < n ; m++ ) {
                if ( dols[m][2] > dols[n][2] ) {
                    if ( DP[m] + dols[n][1] > DP[n]) {
                        DP[n] = DP[m] + dols[n][1];
                        prev[n] = m;
                    }
                }
            }
        }

        // 최고 인덱스 찾기
        int highestIdx = 0;
        for ( int i = 1 ; i < N ; i++ ) {
            if ( DP[i] > DP[highestIdx] ) {
                highestIdx = i;
            }
        }

        // 역추적
        result.add(dols[highestIdx][3]);
        int prevIdx = prev[highestIdx];
        while ( prevIdx != -1 ) {
            result.add(dols[prevIdx][3]);
            prevIdx = prev[prevIdx];
        }
        
    }

    static void output() {
        System.out.println(result.size());
        for ( int i = 0 ; i < result.size() ; i++ ) {
            System.out.println(result.get(i));
        }
    }
    
    public static void main(String[] args) throws IOException {

        input();
        sortDols();
        
        dp();
        output();
        
    }
    
}
