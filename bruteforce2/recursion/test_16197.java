package BaekJoon_Study.bruteforce2.recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * N×M 크기의 보드와 4개의 버튼(위,아래,오른쪽,왼쪽)으로 이루어진 게임
 * 보드에는 여러개의 1.빈칸 2.벽 + 빈칸 중 2개의 빈칸에는 동전이 있음
 * 버튼 누르면 두 개의 동전이 동시에 누른 버튼 방향으로 이동
 * 1.벽 있으면 이동 못함 2.동전있으면 겹쳐질 수 있음 3.낭떠러지면 떨어짐
 * 동전 하나만 떨어트릴 수 있는 최단 경우의 수(10 이하)
 */
public class test_16197 {

    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static Coin[] coins;
    static char[][] board;
    static boolean[][][][] visited;

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        board = new char[N][M];
        coins = new Coin[2];
        int coinIdx = 0;
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                char tmp = input.charAt(j);
                if (tmp == 'o') {
                    coins[coinIdx++] = new Coin(i, j);
                }
                board[i][j] = tmp;
            }
        }

        visited = new boolean[N][M][N][M]; //[첫번째동전의 x위치][첫번째동전의 y위치][두번째동전의 x위치][두번째동전의 y위치]
        System.out.println(bfs());
    }

    //bfs
    static int bfs() {
        Queue<twoCoins> queue = new LinkedList<>();
        queue.offer(new twoCoins(coins[0].x, coins[0].y, coins[1].x, coins[1].y, 0));
        visited[coins[0].x][coins[0].y][coins[1].x][coins[1].y] = true;

        while (queue.isEmpty()) {
            twoCoins now = queue.poll();
            if (now.count >= 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx1 = now.x1 + dx[i];
                int ny1 = now.y1 + dy[i];
                int nx2 = now.x2 + dx[i];
                int ny2 = now.y2 + dy[i];

                //벽체크
                if (!moveCoin(nx1, ny1)) {
                    nx1 = now.x1;
                    ny1 = now.y1;
                }
                if (!moveCoin(nx2, ny2)) {
                    nx2 = now.x2;
                    ny2 = now.y2;
                }

                //떨어지지 않는 동전의 개수
                int flag = 0;
                if(nx1 >= 0 && ny1 >= 0 && nx1 < N && ny1 < M)
                    flag++;
                if(nx2 >= 0 && ny2 >= 0 && nx2 < N && ny2 < M)
                    flag++;

                if(flag == 1)
                    return now.count + 1;
                else if(flag == 2 && !visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.offer(new twoCoins(nx1, ny1, nx2, ny2, now.count + 1));
                }
            }
        }

        return -1;
    }

    //벽인지 판단
    static boolean moveCoin(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == '#') {
            return false;
        }
        return true;
    }

    static class Coin {
        int x, y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class twoCoins {
        int x1, x2, y1, y2, count;

        public twoCoins(int x1, int x2, int y1, int y2, int count) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.count = count;
        }
    }
}
