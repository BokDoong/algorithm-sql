import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] connected;

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        connected = new int[M][2];
        for ( int m = 0 ; m < M ; m++ ) {
            st = new StringTokenizer(br.readLine());
            connected[m][0] = Integer.parseInt(st.nextToken());
            connected[m][1] = Integer.parseInt(st.nextToken());
        }
        
    }

    static int[] degree;
    static List<List<Integer>> graph = new ArrayList<>();;

    static void initializeGraph() {

        degree = new int[N+1];

        for ( int n = 0 ; n < N+1 ; n++ ) {
            graph.add(new ArrayList<>());
        }

        for ( int m = 0 ; m < M ; m++ ) {
            
            int start = connected[m][0];
            int end = connected[m][1];

            degree[end] += 1;
            graph.get(start).add(end);
            
        }
        
    }

    static List<Integer> solve() {

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 부모 노드랑 아예 연결되어 있지 않은 노드 큐에 넣기
        for ( int n = 1 ; n < N+1 ; n++ ) {
            if ( degree[n] == 0 ) {
                queue.add(n);
            }
        }

        // 탐색
        while ( !queue.isEmpty() ) {

            int node = queue.poll();
            result.add(node);

            for ( Integer connectedNode : graph.get(node) ) {
                degree[connectedNode] -= 1;
                if ( degree[connectedNode] == 0 ) {
                    queue.add(connectedNode);
                }
            }
            
        }
        
        return result;
    }

    static void output(List<Integer> result) {
        for ( Integer num : result ) {
            System.out.print(num + " ");
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        input();
        initializeGraph();
        output(solve());
        
    }
    
}
