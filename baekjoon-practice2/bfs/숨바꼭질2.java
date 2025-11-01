import java.util.*;
import java.io.*;

public class Main {

    static int shortestSeconds = 0;
    static int shortestSecondsTime = 0;

    static int N, K;

    static int[] dist = new int[200001];

    static PriorityQueue<Node> queue = new PriorityQueue<>(1, new NodeComparator());

    static class Node {

        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public String toString() {
            return "pos : " + pos + ", time : " + time;
        }
        
    }

    static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node n1, Node n2) {
            return n1.time - n2.time;
        }
        
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static boolean canGo(int pos) {
        if ( 0 <= pos && pos <= 200000 ) {
            return true;
        }
        return false;
    }

    static void bfs() {
        
        // 초기화
        Arrays.fill(dist, -1);
        Node firstNode = new Node(N, 0);
        queue.add(firstNode);
        dist[N] = 0;

        // 탐색
        while ( !queue.isEmpty() ) {

            // 현재 노드 / 시간
            Node nowNode = queue.poll();
            int nowPos = nowNode.pos;
            int nowTime = nowNode.time;

            // 이미 시간이 정해졌는데 그것보다 크다면 끝
            if ( shortestSeconds != 0 && nowTime > shortestSeconds ) {
                break;
            }

            // 도달했을 때
            if ( nowPos == K ) {

                // 아직 업데이트가 안된 상태라면 업데이트
                if ( shortestSeconds == 0 ) {
                    shortestSeconds = nowTime;
                    shortestSecondsTime = 1;
                    continue;
                }

                // 시간이 같다면 +1
                if ( shortestSeconds == nowTime ) {
                    shortestSecondsTime++;
                    continue;
                }
                
            }

            // 이동
            int[] nextPositions = new int[]{nowPos-1, nowPos+1, nowPos*2};
            for ( int i = 0 ; i < 3 ; i++ ) {
                
                int nextPos = nextPositions[i];

                // 갈 수 없다면 
                if ( !canGo(nextPos) ) {
                    continue;
                }

                // 갈 수 있다면 이미 방문하지 않았다면 방문 Or 방문했는데 같은 시간이라면 O
                if ( dist[nextPos] == -1 || dist[nextPos] == nowTime+1 ) {
                    
                    queue.add(new Node(nextPos, nowTime+1));
                    
                    if (dist[nextPos] == -1) {
                        dist[nextPos] = nowTime+1; // 최초 방문이면 기록
                    }
                    
                }
                
            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {

        input();

        // 시작점 - 도달점이 같다면 0
        if ( N == K ) {
            
            System.out.println(0);
            System.out.println(1);
            
        } else {

            // bfs
            bfs();
    
            // 출력
            System.out.println(shortestSeconds);
            System.out.println(shortestSecondsTime);
            
        }
        
    }

    
}
