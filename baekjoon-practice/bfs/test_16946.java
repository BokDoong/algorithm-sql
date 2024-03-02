package BaekJoon_Study.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_16946 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[][] group;
    static int groupId;
    static int[] groupCnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];
        group = new int[N][M];
        groupId = 1;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        //그룹핑 - 0인 애들끼리 자기 갈수있는 곳의 개수가 같은 애들끼리 묶기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] || map[i][j] == 1) continue;
                bfs(i, j);
                groupId++;
            }
        }

        groupCnt = new int[groupId];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                groupCnt[group[i][j]]++;

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) answer.append(0);
                else answer.append(set(i, j) % 10);
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            group[now[0]][now[1]] = groupId;

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (!inRange(nx, ny) || visit[nx][ny] || map[nx][ny] == 1) continue;

                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    static int set(int x, int y) {
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!inRange(nx, ny) || group[nx][ny] == 0) continue;
            set.add(group[nx][ny]); //같은 그룹에 있을 수 있으니 집합으로 중복 없앰
        }

        for (int groupId : set)
            map[x][y] += groupCnt[groupId];

        return map[x][y];
    }

    static boolean inRange(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1) return false;
        return true;
    }
}
