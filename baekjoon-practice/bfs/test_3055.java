package BaekJoon_Study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test_3055 {

    static class Node{
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int R, C;
    static char[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    //고슴도치 큐
    static Queue<Node> sq = new LinkedList<>();
    //물 큐
    static Queue<int[]> wq = new LinkedList<>();

    //main
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //*:물, .:비어있음, X:돌
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);

                //고슴도치
                if(map[i][j] == 'S')
                    sq.add(new Node(i, j, 0));
                //물
                if(map[i][j] == '*')
                    wq.add(new int[]{i, j});
            }
        }

        //main
        bfs();

        //output
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }


    //bfs
    static void bfs() {
        //먼저 물을 이동
        while (!sq.isEmpty()) {
            //홍수 확장
            int w_len = wq.size();
            for (int i = 0; i < w_len; i++) {
                int[] cur_w = wq.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur_w[0] + dx[j];
                    int ny = cur_w[1] + dy[j];

                    //물의 범위 체크
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C)
                        continue;
                    //이동
                    if (map[nx][ny] == '.') {
                        //홍수
                        map[nx][ny] = '*';
                        //물 큐에 넣기
                        wq.add(new int[]{nx, ny});
                    }
                }
            }

            //고슴도치 이동
            int s_len = sq.size();
            for (int i = 0; i < s_len; i++) {
                Node cur_s = sq.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur_s.x + dx[j];
                    int ny = cur_s.y + dy[j];
                    int time = cur_s.time;

                    //범위 체크
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C)
                        continue;
                    //도착
                    if (map[nx][ny] == 'D') {
                        answer = Math.min(answer, time + 1);
                        return;
                    }
                    //고슴도치 이동
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'S';
                        sq.add(new Node(nx, ny, time + 1));
                    }
                }
            }
        }
    }
}
