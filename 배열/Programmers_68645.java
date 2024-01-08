package Book;

public class Programmers_68645 {
    
    private static int[] solution(int n) {
        // 숫자판
        int[][] board = new int[n][n];
        // 사용할 값
        Point start = new Point(0, 0);
        Point end = new Point(n - 1, n - 1);
        int value = 1;

        // 최대 값까지 무한반복
        while (value <= (n * (n + 1) / 2)) {
            // 1. [startY ~ endY][startX] : value++ 대입
            for (int y = start.y; y <= end.y; y++) {
                board[y][start.x] = value++;
            }
            // 2. [endY][startX ~ endX] -> value++ 대입
            for (int x = start.x+1; x <= end.x; x++) {
                board[end.y][x] = value++;
            }
            // 3. [endY ~ startY+1][endX ~ startX+1] -> value++ 대입
            for (int i = 1; i <= (end.y - start.y - 1); i++) {
                board[end.y-i][end.x-i] = value++;
            }
            // 4. start, end 좌표 갱신 -> (startY+2, startX+1), (endY-1, endX-2)
            start.x += 1; start.y += 2;
            end.x -= 2; end.y -= 1;
        }

        // 일차원 배열 만들기
        int order = 0;
        int[] result = new int[n * (n + 1) / 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                result[order++] = board[i][j];
            }
        }

        return result;
    }

    private static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
