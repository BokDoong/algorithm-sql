import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] board;
    static int H, W, Sr, Sc, Fr, Fc;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static Queue<Node> queue = new LinkedList<>();

    static boolean[][] visited;

    static class Node {

        int x;
        int y;

        Node ( int x, int y ) {
            this.x = x;
            this.y = y;
        }
        
    }

    static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        
        for ( int n = 0 ; n < N ; n++ ) {
            
            st = new StringTokenizer(br.readLine());

            for ( int m = 0 ; m <  M ; m++ ) {
                int num = Integer.parseInt(st.nextToken());
                if ( num == 1 ) {
                    num = -1;
                }
                board[n][m] = num;
            }
            
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken());
        Sc = Integer.parseInt(st.nextToken());
        Fr = Integer.parseInt(st.nextToken());
        Fc = Integer.parseInt(st.nextToken());
        
    }

    static boolean isBlocked(int x, int y) {
        return board[x][y] == -1;
    }

    static boolean hasVisited(int x, int y) {
        return visited[x][y];
    }

    static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    // v -> 0 : 상, 1 : 하, 2 : 좌, 3 : 우
    static boolean canGo(int x, int y, int v) {
        
        if ( v == 0 ) {
            
            for ( int m = 0 ; m < W ; m++ ) {
                if ( isOut(x - 1, y + m) || isBlocked(x - 1, y + m) ) {
                    return false;
                }
            }
            
        }
        else if ( v == 1 ) {
            
            for ( int m = 0 ; m < W ; m++ ) {
                if ( isOut(x + H, y + m) || isBlocked(x + H, y + m) ) {
                    return false;
                }
            }
            
        }
        else if ( v == 2 ) {
            
            for ( int n = 0 ; n < H ; n++ ) {
                if ( isOut(x + n, y - 1) || isBlocked(x + n, y - 1) ) {
                    return false;
                }
            }
            
        }
        else if ( v == 3 ) {
            
            for ( int n = 0 ; n < H ; n++ ) {
                if ( isOut(x + n, y + W) || isBlocked(x + n, y + W) ) {
                    return false;
                }
            }
                        
        }
        else {
            System.out.println("방향(v)가 잘못 들어옴");
        }

        return true;
        
    }

    static void solve() {

        // 초기화
        Node startNode = new Node(Sr - 1, Sc - 1);
        queue.add(startNode);
        visited[Sr - 1][Sc - 1] = true;

        // BFS
        while ( !queue.isEmpty() ) {

            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;

            for ( int v = 0 ; v < 4 ; v++ ) {

                int nextX = nowX + dx[v];
                int nextY = nowY + dy[v];

                if ( isOut(nextX, nextY) || hasVisited(nextX, nextY) ) {
                    continue;
                }

                if ( canGo(nowX, nowY, v) ) {
        
                    board[nextX][nextY] = board[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                    
                    queue.add(new Node(nextX, nextY));
                    
                }
                
            }
            
        }
        
    }

    static void output() {

        if ( !visited[Fr-1][Fc-1] ) {
            System.out.println(-1);
            return;
        }

        System.out.println(board[Fr-1][Fc-1]);
        
    }
    
    public static void main(String[] args) throws IOException {

        input();
        solve();
        output();
        
    }

    
}
