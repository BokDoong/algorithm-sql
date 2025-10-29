import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int N;
    static int M;
    static int P;

    static char[][] board;
    static List<Integer> moveCount;
    static HashMap<Integer, List<Node>> castles = new HashMap<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {

        private int x;
        private int y;

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

        private Node node;
        private int movedCount;

        public QueueNode(Node node, int moveCount) {
            this.node = node;
            this.movedCount = moveCount;
        }
        
    }

    public static void input() throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        moveCount = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
    }

    public static void initialize() {
        
        // 플레이어별 성 위치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != '.' && board[i][j] != '#') {
                    Integer player = Integer.valueOf(board[i][j] - '0');
                    Node castle = new Node(i, j);
                    if (castles.containsKey(player)) {
                        castles.get(player).add(castle);
                    } else {
                        List<Node> list = new ArrayList<>();
                        list.add(castle);
                        castles.put(player, list);
                    }
                }
            }
        }
        
    }

    public static boolean canGo(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        // 입력
        input();

        // 플레이어별 성위치 업대이트
        initialize();

        // 게임
        while (true) {
            
            boolean isEnd = true;
            
            for (int p = 1; p <= P; p++) {
                // 플레이어의 성, 최대 움직일 수 있는 카운트
                List<Node> playerCastles = castles.get(p);
                int moveMaxCount = moveCount.get(p-1);

                // 플레이어의 성 넣기
                Queue<QueueNode> queue = new LinkedList<>();
                for (int i = 0; i < playerCastles.size(); i++) {
                    QueueNode qn = new QueueNode(playerCastles.get(i), 0);
                    queue.add(qn);
                }
                List<Node> newNodes = new ArrayList<>();
                castles.put(p, newNodes);

                // 찾기
                while (!queue.isEmpty()) {
                    QueueNode qn = queue.poll();
                    int movedCount = qn.movedCount;
                    
                    if (movedCount < moveMaxCount) {
                        for (int i = 0; i < 4; i++) {
                            int nextX = qn.node.x + dx[i];
                            int nextY = qn.node.y + dy[i];

                            if (canGo(nextX, nextY) && board[nextX][nextY] == '.') {
                                board[nextX][nextY] = (char)((char)p + '0');
                                Node nextNode = new Node(nextX, nextY);
                                castles.get(p).add(nextNode);
                                queue.add(new QueueNode(nextNode, movedCount+1));
                                isEnd = false;
                            }
                            
                        }
                    }
                }
                
            }

            // 진행못했으면 끝
            if (isEnd) {
                break;
            }
        }

        // 출력
        int[] result = new int[P];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != '#' && board[i][j] != '.') {
                    int p = (int)(board[i][j] - '0');
                    result[p-1] += 1;
                }
            }
        }
        for (int p = 0; p < P; p++) {
            System.out.print(result[p] + " ");
        }
    }
    
}
