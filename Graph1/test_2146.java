package BaekJoon_Study.Graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_2146 {

    static int N, island, answer, landNum;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point {
        int x, y, island;
        public Point(int x, int y, int island) {
            this.x = x;
            this.y = y;
            this.island = island;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                //같은 육지이면 패스
                if(visited[nextX][nextY] == true || map[nextX][nextY] == landNum) {
                    continue;
                }

                // 방문체크
                visited[nextX][nextY] = true;

                if(map[nextX][nextY] == 0) {
                    queue.offer(new Point(nextX, nextY, now.island + 1));
                } else {
                    // 이동한 거리가 현재 담고있는 최소거리보다 짧으면 담는다
                    answer = answer > now.island ? now.island : answer;
                }
            }
        }
    }

    static void setMap(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            map[now.x][now.y] = island;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && visited[nextX][nextY] == false && map[nextX][nextY] == 1 ) {
                    queue.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N][N];

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //섬을 구분 - 각 섬마다 고유의 숫자(cnt)부여
        island = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    island++;
                    setMap(i, j);
                }
            }
        }

        //육지(not 0)이면 bfs
        answer = 1000;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0) {
                    visited = new boolean[N][N];
                    landNum = map[i][j];
                    bfs(i, j);
                }
            }
        }

        //output
        System.out.println(answer);
    }
}
