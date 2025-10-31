import java.io.*;
import java.util.*;

public class Main {

    static int result = Integer.MAX_VALUE;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int N, M;
    static char[][] board;

    static int x1, y1, x2, y2;

    static void debug(int x1, int y1, int x2, int y2) {
        System.out.println(" 코인 1 : " + x1 + " " + y1);
        System.out.println(" 코인 2 : " + x2 + " " + y2);
        System.out.println("=========================");
    }

    static void input() throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        boolean isFirstCoin = true;
        for (int i = 0; i < N; i++) {
            String tmpStr = br.readLine();
            for (int j = 0; j < M; j++) {
                char tmpChar = tmpStr.charAt(j);
                if (tmpChar == 'o') {
                    if (isFirstCoin) {
                        x1 = i;
                        y1 = j;
                        isFirstCoin = false;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
                board[i][j] = tmpChar;
            }
        }
        
    }

    static boolean isOut(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M) {
            return false;
        }
        return true;
    }

    static boolean isWall(int x, int y) {
        if (board[x][y] == '#') {
            return true;
        }
        return false;
    }

    static void backTracking(int x1, int y1, int x2, int y2, int moveCount) {
        
        // 10번째 넘었으면 끝
        if (moveCount >= 10) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {

            // 첫번째 동전
            int nextX1 = x1 + dx[i];
            int nextY1 = y1 + dy[i];
            boolean isOut1 = isOut(nextX1, nextY1);
                
            // 두번째 동전
            int nextX2 = x2 + dx[i];
            int nextY2 = y2 + dy[i];
            boolean isOut2 = isOut(nextX2, nextY2);

            // 두개 다 나갔으면 다음으로
            if (isOut1 && isOut2) {
                continue;
            }
            
            // 하나만 나갔으면 체킹
            if (isOut1 ^ isOut2) {
                result = Math.min(result, moveCount+1);
                continue;
            }

            // 둘 다 안에 있다면
            // 벽이라면 원래로 되돌리기
            if (isWall(nextX1, nextY1)) {
                nextX1 = x1;
                nextY1 = y1;
            }
            if (isWall(nextX2, nextY2)) {
                nextX2 = x2;
                nextY2 = y2;
            }

            // 제자리 방지
            if (nextX1 == x1 && nextY1 == y1 && nextX2 == x2 && nextY2 == y2) {
                continue;
            }
            
            // 백트래킹
            backTracking(nextX1, nextY1, nextX2, nextY2, moveCount+1);
        }
        
    }

    public static void main(String[] args) throws IOException {

        input();
        
        backTracking(x1, y1, x2, y2, 0);
        
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
        
    }
    
}
