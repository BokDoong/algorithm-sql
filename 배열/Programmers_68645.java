package Book;

public class Programmers_68645 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // int[] result = my_solution(n);
        int[] result = book_solution(n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] book_solution(int n) {
        // dx, dy
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};

        // 숫자판, 사용할 변수
        int[][] board = new int[n][n];
        int value = 1;
        int x = 0, y = 0, d = 0;

        while (true) {
            // 1. 값 넣기 -> 좌표 이동
            board[y][x] = value++;
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 2. 다음 칸에 숫자가 있거나 범위 벗어나면 방향 바꾸기
            if (nx == -1 || ny == -1 || nx == n || ny == n || board[ny][nx] != 0) {
                d = (d + 1) % 3;
                ny = y + dy[d];
                nx = x + dx[d];

                // 3. 한번 더 체크해서 break
                if (nx == -1 || ny == -1 || nx == n || ny == n || board[ny][nx] != 0)
                    break;
            }

            y = ny;
            x = nx;
        }

        return convertToResult(n, board);
    }

    private static int[] my_solution(int n) {
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

        return convertToResult(n, board);
    }

    private static int[] convertToResult(int n, int[][] board) {
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
