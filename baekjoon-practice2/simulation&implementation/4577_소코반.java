import java.util.*;
import java.io.*;

class Main {

    static boolean[][] goal; // ★ 추가

    static void play(int turn, int R, int C, char[][] board, String commands, List<Node> targetPos) {

        boolean completed = false;

        for ( int i = 0 ; i < commands.length() ; i++ ) {
            board = move(board, commands.charAt(i), R, C);

            if ( isEnd(board, targetPos) ) {
                completed = true;
                break;
            }
        }

        board = upperInTargetPos(board, targetPos);
        if ( completed ) {
            output(turn, "complete", R, C, board);
        } else {
            output(turn, "incomplete", R, C, board);
        }
    }

    // 이동
    static char[][] move(char[][] board, char commands, int R, int C) {

        int playerX = 0;
        int playerY = 0;
        for ( int r = 0 ; r < R ; r++ ) {
            for ( int c = 0 ; c < C ; c++ ) {
                if ( board[r][c] == 'w' ) {
                    playerX = r;
                    playerY = c;
                }
            }
        }

        int vector = determineVector(commands);
        int nextPlayerX = playerX + dx[vector];
        int nextPlayerY = playerY + dy[vector];

        if (nextPlayerX < 0 || nextPlayerX >= R || nextPlayerY < 0 || nextPlayerY >= C) {
            return board;
        }

        char nextValue = board[nextPlayerX][nextPlayerY];

        // 벽
        if ( nextValue == '#' ) return board;

        // 빈칸 / 목표
        if ( nextValue == '.' || nextValue == '+' ) {
            board[nextPlayerX][nextPlayerY] = 'w';
            board[playerX][playerY] = goal[playerX][playerY] ? '+' : '.';
        }
        // 박스
        else if ( nextValue == 'b' ) {

            int nextBoxX = nextPlayerX + dx[vector];
            int nextBoxY = nextPlayerY + dy[vector];

            if (nextBoxX < 0 || nextBoxX >= R || nextBoxY < 0 || nextBoxY >= C) {
                return board;
            }

            if ( board[nextBoxX][nextBoxY] == '.' || board[nextBoxX][nextBoxY] == '+' ) {
                board[nextBoxX][nextBoxY] = 'b';
                board[nextPlayerX][nextPlayerY] = 'w';
                board[playerX][playerY] = goal[playerX][playerY] ? '+' : '.';
            }
        }

        return board;
    }

    static char determineVector(char command) {
        if ( command == 'U' ) return 0;
        else if ( command == 'D' ) return 1;
        else if ( command == 'L' ) return 2;
        else return 3;
    }

    // 종료 조건
    static boolean isEnd(char[][] board, List<Node> targetPos) {
        for ( Node node : targetPos ) {
            if ( board[node.x][node.y] != 'b' ) {
                return false;
            }
        }
        return true;
    }

    // 출력용 대문자 처리
    static char[][] upperInTargetPos(char[][] board, List<Node> targetPos) {
        for ( Node node : targetPos ) {
            if ( board[node.x][node.y] == 'b' ) {
                board[node.x][node.y] = 'B';
            } else if ( board[node.x][node.y] == 'w' ) {
                board[node.x][node.y] = 'W';
            }
        }
        return board;
    }

    static void output(int turn, String result, int R, int C, char[][] board) {
        System.out.println("Game " + turn + ": " + result);
        for ( int r = 0 ; r < R ; r++ ) {
            for ( int c = 0 ; c < C ; c++ ) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void game() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int turn = 1;
        while ( true ) {

            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if ( R == 0 && C == 0 ) break;

            goal = new boolean[R][C]; // ★ 추가
            List<Node> targetPos = new ArrayList<>();
            char[][] board = new char[R][C];

            for ( int r = 0 ; r < R ; r++ ) {
                String tmp = br.readLine();
                for ( int c = 0 ; c < C ; c++ ) {
                    char ch = tmp.charAt(c);

                    if ( ch == '+' || ch == 'W' || ch == 'B' ) {
                        goal[r][c] = true;
                        targetPos.add(new Node(r, c));
                    }

                    if ( ch == 'W' ) board[r][c] = 'w';
                    else if ( ch == 'B' ) board[r][c] = 'b';
                    else if ( ch == '+' ) board[r][c] = '+';
                    else board[r][c] = ch;
                }
            }

            String commands = br.readLine();
            play(turn, R, C, board, commands, targetPos);
            turn++;
        }
    }

    public static void main(String[] args) throws IOException {
        game();
    }
}
