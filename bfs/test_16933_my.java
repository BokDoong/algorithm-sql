package BaekJoon_Study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test_16933_my {

    static int N, M, K;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visited;

    static class Node{
        int x, y, cnt, breakWall, time;

        //time: 0-낮, 1-밤
        public Node(int x, int y, int cnt, int breakWall, int time) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakWall = breakWall;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        //main
        visited = new boolean[N][M][K + 1][2];

        //output
        System.out.println(bfs(new Node(0, 0, 1, 0, 0)));
    }

    static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1)
                return now.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                //벽o
                if (map[nx][ny] == 1) {
                    //밤이면
                    if (now.breakWall < K && now.time == 1 && !visited[nx][ny][now.breakWall+1][1]) {
                        visited[nx][ny][now.breakWall+1][1] = true;
                        queue.add(new Node(now.x, now.y, now.cnt + 1, now.breakWall, 0));
                    }
                    //낮이면
                    if (now.breakWall < K && now.time == 0 && !visited[nx][ny][now.breakWall+1][0]) {
                        visited[nx][ny][now.breakWall+1][0] = true;
                        queue.add(new Node(nx, ny, now.cnt + 1, now.breakWall + 1, 1));
                    }
                }
                //벽x
                else {
                    if (!visited[nx][ny][now.breakWall][now.time]) {
                        visited[nx][ny][now.breakWall][now.time] = true;
                        queue.add(new Node(nx, ny, now.cnt+1, now.breakWall, Math.abs(now.time - 1)));
                    }
                }
            }
        }

        return -1;
    }
}
