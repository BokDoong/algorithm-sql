import java.io.*;
import java.util.*;

public class Main {

    static Integer result = -1 * Integer.MAX_VALUE;
    
    static int N, M, D;
    static int[][] board;
    
    static int[][][] distFromArchor;

    static class Monster {

        int x;
        int y;

        public Monster() {
            this.x = -1;
            this.y = -1;
        }

        public void update(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean notYetKilled() {
            return this.x == -1;
        }

        @Override
        public String toString() {
            return " x : " + x + ", y : " + y;
        }
        
    }

    static void debug() {
        for ( int aY = 0; aY < 3; aY++ ) {
            for ( int x = 0; x < N; x++ ) {
                System.out.println(Arrays.toString(distFromArchor[aY][x]));
            }
            System.out.println("=============");
        }
    }

    static void input() throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N+1][M];
        for ( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 0; j < M; j++ ) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
    }

    static void calculateDistFromArchors() {

        distFromArchor = new int[M][N][M];
        
        for ( int aY = 0; aY < M; aY++ ) {
            for ( int x = 0; x < N; x++ ) {
                for ( int y = 0; y < M; y++ ) {
                    distFromArchor[aY][x][y] = Math.abs(N - x) + Math.abs(aY - y);
                }
            }
        }
        
    }

    static List<Integer[]> extractArchors() {

        List<Integer[]> archors = new ArrayList<>();
        for ( int a1 = 0; a1 < M; a1++ ) {
            for ( int a2 = a1+1; a2 < M; a2++ ) {
                for ( int a3 = a2+1; a3 < M; a3++ ) {
                    Integer[] sets = {a1, a2, a3};
                    archors.add(sets);
                }
            }
        }

        return archors;
        
    }

    static int[][] deepCopy(int[][] src) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, copy[i], 0, M);
        }
        return copy;
    }

    static void updateKillMonster(Monster monster, int x, int y, int aY) {

        // 거리에서 벗어나있다면 X
        int nextDist = distFromArchor[aY][x][y];
        if (nextDist > D) {
            return;
        }
        
        // 아직 죽인 몬스터가 없다면 바로 죽이기
        if ( monster.notYetKilled() ) {
            monster.update(x, y);
            return;
        }

        // 더 가까운 애 -> 왼쪽에 있는 애
        int nowDist = distFromArchor[aY][monster.x][monster.y];

        if ( nextDist < nowDist ) {
            monster.update(x, y);
            return;
        } 

        if ( nextDist == nowDist && y < monster.y ) {
            monster.update(x, y);
            return;
        }

        return;
        
    }

    static int playGame(Integer[] archors) {

        // 궁수 위치
        Integer a1 = archors[0];
        Integer a2 = archors[1];
        Integer a3 = archors[2];

        // 게임
        int gameResult = 0;
        boolean isEnd = false;
        int[][] gameBoard = deepCopy(board); 

        while( !isEnd ) {

            // 끝 초기화
            isEnd = true;

            // 궁수별 죽일 몬스터
            Monster a1Monster = new Monster();
            Monster a2Monster = new Monster();
            Monster a3Monster = new Monster();

            // 죽일 몬스터 선정
            for ( int x = 0; x < N; x++ ) {
                for ( int y = 0; y < M; y++) {
                    if ( gameBoard[x][y] == 1 ) {
                        // 끝인지 체크
                        isEnd = false;
                        // 각 궁수마다 죽일놈인지 업데이트
                        updateKillMonster(a1Monster, x, y, a1);
                        updateKillMonster(a2Monster, x, y, a2);
                        updateKillMonster(a3Monster, x, y, a3);
                    }
                }
            }

            // 죽이기
            int killCount = 0;
            Monster[] monsters = {a1Monster, a2Monster, a3Monster};
            for ( int i = 0 ; i < 3 ; i++ ) {
                Monster m = monsters[i];

                // 죽인 애가 없다면 넘기기
                if ( m.x == -1 ) {
                    continue;
                }
                
                if ( gameBoard[m.x][m.y] == 1 ) {
                    gameBoard[m.x][m.y] = 0;
                    killCount += 1;
                }
                
            }
            gameResult = gameResult + killCount;

            // 몬스터 아래로 이동
            int[][] tmpBoard = new int[N][M];
            for ( int i = 1 ; i < N ; i++ ) {
                for ( int j = 0 ; j < M ; j++ ) {
                    tmpBoard[i][j] = gameBoard[i-1][j];
                }
            }
            gameBoard = tmpBoard;
            
        }

        return gameResult;

    }

    public static void main(String[] args) throws IOException {
        
        input();
        
        calculateDistFromArchors();
        
        List<Integer[]> archors = extractArchors();
        for ( Integer[] tmpArchors : archors ) {
            int gameResult = playGame(tmpArchors);
            result = Math.max(result, gameResult);
        }

        System.out.println(result);
            
    }
    
}
