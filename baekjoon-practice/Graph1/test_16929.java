package BaekJoon_Study.Graph1;

import java.util.Scanner;

public class test_16929 {
    static int n, m;
    static int target_x, target_y;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void dfs(int x, int y, int now){

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //범위 초과
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            //같은 색 여부
            if(board[x][y] == board[nx][ny]){
                //원점으로 돌아온거면 사이클
                if (nx == target_x && ny == target_y && now >= 4) {
                    System.out.println("Yes");
                    System.exit(0);
                }
                //방문 안한 경우
                if (visited[nx][ny]==false) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, now + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args){

        //input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        //main
        //시작점을 저장 + visited 로 확인 + dfs
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]==false) {
                    target_x = i;
                    target_y = j;
                    visited[i][j] = true;
                    dfs(i, j, 1);
                }
            }
        }

        //output
        System.out.println("No");
    }

}

