import java.io.*;
import java.util.*;

class Main {

    static int N, K;
    static int[][] board;
    static int S, X, Y;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static TreeSet<Integer> viruses = new TreeSet<>();
    static HashMap<Integer, List<Node>> virusNodes = new HashMap<>();

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
        int time;
        int virus;

        public QueueNode(Node node, int time, int virus) {
            this.node = node;
            this.time = time;
            this.virus = virus;
        }
        
    }

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for ( int i = 0 ; i < N ; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 0 ; j < N ; j++ ) {
                int tmp = Integer.parseInt(st.nextToken());
                if ( tmp > 0 ) {
                    viruses.add(tmp);
                }
                board[i][j] = tmp;
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
    }

    static void initialize() {

        // 존재하는 바이러스 초기화
        for ( int virus : viruses ) {
            List<Node> nodes = new ArrayList<>();
            virusNodes.put(virus, nodes);
        }

        // 위치 넣기
        for ( int i = 0 ; i < N ; i++ ) {
            for ( int j = 0 ; j < N ; j++ ) {

                int virus = board[i][j];
                
                if ( virus > 0 ) {
                    
                    Node node = new Node(i, j);
                    virusNodes.get(virus).add(node);
                    
                }
                
            }
        }
        
    }

    static boolean canInfect(int x, int y) {

        if ( x < 0 || y < 0 || x >= N || y >= N ) {
            return false;
        }

        if ( board[x][y] > 0 ) {
            return false;
        }

        return true;
        
    }

    static void game() {

        Queue<QueueNode> queue = new LinkedList<>();
        
        // 작은 바이러스 부터 큐 초기화
        for ( Integer virus : viruses ) {
            List<Node> nodes = virusNodes.get(virus);
            for ( Node node : nodes ) {
                queue.add(new QueueNode(node, 0, virus));
            }
        }

        // BFS
        while ( !queue.isEmpty() ) {
            
            QueueNode queueNode = queue.poll();

            if ( queueNode.time == S ) {
                continue;
            }

            for ( int i = 0 ; i < 4 ; i++ ) {

                int nextX = queueNode.node.x + dx[i];
                int nextY = queueNode.node.y + dy[i];

                if ( !canInfect(nextX, nextY) ) {
                    continue;
                }

                board[nextX][nextY] = queueNode.virus;
                Node newNode = new Node(nextX, nextY);
                QueueNode newQueueNode = new QueueNode(newNode, queueNode.time + 1, queueNode.virus);
                queue.add(newQueueNode);
                
            }
                
        }
        
    }


    public static void main(String[] args) throws IOException {

        input();
        initialize();
        
        game();

        System.out.println(board[X-1][Y-1]);

    }
    
}
