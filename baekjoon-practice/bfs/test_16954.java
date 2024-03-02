package BaekJoon_Study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test_16954 {

    static class info{
        int x, y;

        public info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N=8;
    static int startX = 7, startY = 0, endX=0, endY = 7;
    static Queue<info> person = new LinkedList<>();
    static char [][] map;
    static boolean [][] visited;
    static int [] dx = {0,-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = str.charAt(j);
            }
        }

        if(bfs()) System.out.println(1);
        else System.out.println(0);
    }

    public static boolean bfs() {
        person.add(new info(startX, startY));

        while(!person.isEmpty()) {
            visited = new boolean[N][N];
            int size = person.size();

            for(int j=0;j<size;j++) {

                info in = person.poll();

                if(map[in.x][in.y]=='#') continue;

                for(int i=0;i<9;i++) {

                    int nx = in.x+dx[i];
                    int ny = in.y+dy[i];

                    if(range(nx,ny)) {
                        if(nx==endX && ny==endY) {
                            return true;
                        }

                        if(map[nx][ny]!='#' && !visited[nx][ny]) {
                            person.offer(new info(nx,ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            move();
        }

        return false;
    }

    public static boolean range(int x, int y) {
        return x>=0 && y>=0 && x<N && y<N;
    }

    public static void move() {

        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if(i==0) map[i][j] = '.';
                else map[i][j] = map[i-1][j];
            }
        }
    }
}

