import java.io.*;
import java.util.*;

class Main {

    static int N, M, P;
    static int[] S;
    static char[][] board;

    static Map<Integer, List<Node>> indexes = new HashMap<>();

    static class Node {

        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x : " + x + ", y : " + y;
        }
        
    }

    // 입력
    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = new int[P];
        for ( int p = 0 ; p < P ; p++ ) {
            S[p] = Integer.parseInt(st.nextToken());
        }

        board = new char[N][M];
        for ( int n = 0 ; n < N ; n++ ) {

            st = new StringTokenizer(br.readLine());
            String tmpChar = st.nextToken();

            for ( int m = 0 ; m < M ; m++ ) {

                // 입력
                char target = tmpChar.charAt(m);
                board[n][m] = target;

                // 숫자이면 인덱스 셋팅
                if ( 49 <= (int)target && (int)target <= 57 ) {

                    int targetInt = (int)target - 48;
                    
                    if ( indexes.containsKey(targetInt) ) {
                        indexes.get(targetInt).add(new Node(n, m));
                    }
                    else {
                        List<Node> newNodes = new ArrayList<>();
                        newNodes.add(new Node(n, m));
                        indexes.put(targetInt, newNodes);
                    }
                    
                }
                
            }
            
        }
        
    }

    // 이동
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class QueueNode {

        Node node;
        int movedCount;

        QueueNode(Node node, int movedCount) {
            this.node = node;
            this.movedCount = movedCount;
        }
        
    }

    static boolean canGo(int x, int y) {
        if ( x < 0 || x >= N || y < 0 || y >= M ) {
            return false;
        }
        if ( board[x][y] == '.' ) {
            return true;
        }
        return false;
    }

    static void move() {

        while ( true ) {
            
            boolean moved = false;
            
            // 하나씩 돌아가며 이동
            for ( int p = 1 ; p <= P ; p++ ) {

                // 새로운 노드 리스트
                List<Node> newNodes = new ArrayList<>();
    
                // 큐 초기화 - 지금 인덱스의 노드가 있는 위치들 추가
                Queue<QueueNode> queue = new LinkedList<>();
                for ( Node node : indexes.get(p) ) {
                    queue.add(new QueueNode(node, 0));
                }
    
                // BFS
                while ( !queue.isEmpty() ) {
    
                    // 노드
                    QueueNode nowQueueNode = queue.poll();
    
                    // 다음 노드
                    for ( int i = 0 ; i < 4 ; i++ ) {
                        
                        int nextX = nowQueueNode.node.x + dx[i];
                        int nextY = nowQueueNode.node.y + dy[i];
    
                        if ( nowQueueNode.movedCount < S[p-1] && canGo(nextX, nextY) ) {
                            
                            // 보드 마킹
                            board[nextX][nextY] = (char)(p + '0');
                            
                            // 다음 노드
                            Node nextNode = new Node(nextX, nextY);
                            queue.add(new QueueNode(nextNode, nowQueueNode.movedCount+1));
                            newNodes.add(nextNode);

                            // 움직였다고 표시
                            moved = true;
                            
                        }
                        
                    }
                    
                }

                // 인덱스의 노드리스트 리셋
                indexes.put(p, newNodes);
                
            }

            // 움직이지 않았으면 끝
            if ( !moved ) {
                break;
            }
            
        }
        
    }

    static void output() {

        int[] result = new int[P];
        
        for ( int n = 0 ; n < N ; n++ ) {
            for ( int m = 0 ; m < M ; m++ ) {
                if ( 49 <= (int)board[n][m] && (int)board[n][m] <= 57 ) {
                    result[(int)board[n][m] - 49] += 1;
                }
            }
        }

        for ( int i = 0 ; i < P ; i++ ) {
            System.out.print(result[i] + " ");
        }
        
    }


    public static void main(String[] args) throws IOException {

        input();
        move();
        output();
        
    }
    
}
