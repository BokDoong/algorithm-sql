import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;

    static List<Node> canInputVirusNodes = new ArrayList<>();
    
    static int[][][] minDist;
    static int result;

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x : " + x + ", y : " + y;
        }
        
    }

    static class QueueNode {

        Node node;
        int depth;

        public QueueNode(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
        
    }

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for ( int i = 0 ; i < N ; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 0 ; j < N ; j++ ) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
                if ( val == 2) {
                    canInputVirusNodes.add(new Node(i, j));
                }
            }
        }
        
    }

    static void initialize() {
        
        int maxCanInputVirusSize = canInputVirusNodes.size();
        minDist = new int[N][N][maxCanInputVirusSize];
        
        result = Integer.MAX_VALUE;
        
    }

    static boolean isOut(int x, int y) {
        
        if ( x < 0 || y < 0 || x >= N || y >= N ) {
            return true;
        }
        
        return false;
        
    }

    static int calculateMinDistFromCanInputVirusNodes(int[] virusesIdx) {
        
        int[][] dist = new int[N][N];
        for ( int i = 0 ; i < N ; i++ ) {
            Arrays.fill(dist[i], -1);
        }

        Queue<Node> queue = new LinkedList<>();
        for ( int i = 0 ; i < M ; i++ ) {
            Node s = canInputVirusNodes.get(virusesIdx[i]);
            dist[s.x][s.y] = 0;
            queue.add(s);
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while ( !queue.isEmpty() ) {

            Node cur = queue.poll();
            for ( int d = 0 ; d < 4 ; d++ ) {
                
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (isOut(nx, ny)) continue;
                if (board[nx][ny] == 1) continue;          // 벽은 불가
                if (dist[nx][ny] != -1) continue;          // 이미 방문
                
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.add(new Node(nx, ny));
                
            }
            
        }

        // 최종 시간: 0(빈칸)만 대상으로 최대 거리, 2는 무시(통과만 허용)
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 1) {

                    // 감염칸이라면 넘기기
                    boolean isVirus = false;
                    
                    for ( int k = 0 ; k < M ; k++ ) {
                        Node s = canInputVirusNodes.get(virusesIdx[k]);
                        if ( s.x == i && s.y == j ) {
                            isVirus = true;
                            break;
                        }
                    }

                    if (isVirus) {
                        continue;
                    }

                    // 감염 못한 빈칸 존재
                    if (dist[i][j] == -1) return -1;   
                        
                    maxTime = Math.max(maxTime, dist[i][j]);
                }
            }
        }
        return maxTime;
        
    }

    static void backTracking(boolean[] visited, int startIdx, int depth) {

        if ( depth == M ) {
            
            int[] virusesIdx = new int[M];

            int idx = 0;
            for ( int i = 0 ; i < visited.length ; i++ ) {
                if ( visited[i] ) {
                    virusesIdx[idx] = i;
                    idx++;
                }
            }

            int tmpResult = calculateMinDistFromCanInputVirusNodes(virusesIdx);
            if ( tmpResult != -1 ) {
                result = Math.min(result, tmpResult);
            }
            
            return;
        }

        for ( int i = startIdx ; i < canInputVirusNodes.size() ; i++ ) {

            if ( visited[i] == true ) {
                continue;
            }

            visited[i] = true;
            backTracking(visited, i+1, depth+1);
            visited[i] = false;
            
        }
       
    }
    
    public static void main(String[] args) throws IOException {

        input();
        initialize();

        boolean[] visited = new boolean[canInputVirusNodes.size()];
        backTracking(visited, 0, 0);

        if ( result == Integer.MAX_VALUE ) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
        
    }
    
}
