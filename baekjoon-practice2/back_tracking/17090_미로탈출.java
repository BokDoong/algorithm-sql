import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static char[][] maze;
    
    static boolean[][] visited;
    static boolean[][] canExit;

    static class Node {

        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
    }

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        visited = new boolean[N][M];
        canExit = new boolean[N][M];

        for ( int i = 0 ; i < N ; i++ ) {
            
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            for ( int j = 0 ; j < M ; j++ ) {
                maze[i][j] = tmp.charAt(j);
            }
            
        }
        
    }

    static boolean isOut(int x, int y) {
        if ( x < 0 || x >= N || y < 0 || y >= M ) {
            return true;
        }
        return false;
    }

    static void markNodesExit(Set<Node> nodes) {
        for ( Node node : nodes ) {
            canExit[node.x][node.y] = true;
        }
    }

    static Node toNextNode(int x, int y) {
        if ( maze[x][y] == 'U' ) {
            return new Node(x-1, y);
        } else if ( maze[x][y] == 'R' ) {
            return new Node(x, y+1);
        } else if ( maze[x][y] == 'D' ) {
            return new Node(x+1, y);
        } else {
            return new Node(x, y-1);
        }
    }

    // x, y : 가장 마지막 위치
    static void backTracking(Set<Node> passedNodes, int x, int y) {

        // 나갔는지 체크
        if ( isOut(x, y) ) {
            markNodesExit(passedNodes);
            return;
        }

        // 안나갔다면
        // 방문한적 있다
        if ( visited[x][y] ) {

            // 지나온 애라면 모두 탈출 X
            if ( passedNodes.contains(new Node(x, y)) ) return;

            // 해당 노드가 탈출 노드라면 탈출
            if ( canExit[x][y] ) {
                markNodesExit(passedNodes);
                return;
            }
            
        }

        // 방문한적 없다
        // 지금꺼 넣고
        visited[x][y] = true;
        passedNodes.add(new Node(x, y));
        // 다음 노드 백트래킹
        Node nextNode = toNextNode(x, y);
        backTracking(passedNodes, nextNode.x, nextNode.y);
    }

    static void solve() {

        for ( int x = 0 ; x < N ; x++ ) {
            for ( int y = 0 ; y < M ; y++ ) {
                if ( !visited[x][y] ) {
                    backTracking(new HashSet<>(), x, y);
                }
            }
        }
        
    }

    static int calculateResult() { 
        int result = 0;
        for ( int x = 0 ; x < N ; x++ ) {
            for ( int y = 0 ; y < M ; y++ ) {
                if ( canExit[x][y] ) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();
        System.out.println(calculateResult());
        
    }
    
}
