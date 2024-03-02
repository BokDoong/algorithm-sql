package BaekJoon_Study.Graph1;

import java.util.*;

public class test_16947 {
    static boolean visited[], isCycle;
    static int N, distance[];
    static ArrayList<Integer>[] subway;
    static Queue<Integer> queue = new LinkedList<Integer>();

    private static void bfs() {
        int cnt = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                int tmp = queue.poll();
                // 연결된 구간을 다음 탐색지에 추가
                for (int i : subway[tmp]) {
                    // 거리가 이미 구해진 역은 제외
                    if (distance[i] != -1) continue;
                    distance[i] = cnt;
                    queue.add(i);
                }
            }
            cnt++; // 순환선과의 거리
        }
    }

    static void dfs(int prev, int curr) {
        visited[curr] = true;

        for (int i = 0; i < subway[curr].size(); i++) {
            int next = subway[curr].get(i);

            //바로 이전 노드가 아니면서 방문 했던 곳 - 순환선
            if (visited[next] && next != prev) {
                isCycle = true;
                distance[next] = 0;
                queue.add(next);
                break;
            } else if(!visited[next]) {
                //dfs
                dfs(curr, next);
                // 사이클에 속하는 경우
                if (isCycle) {
                    // 이미 사이클에 속한 곳을 만남 => 사이클을 다 돌았다!
                    if (distance[next] == 0) {
                        isCycle = false;
                    } else {
                        distance[next] = 0;
                        queue.add(next);
                    }
                    return;
                }

            }
        }

    }

    public static void main(String[] args){
        //input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, -1);

        subway = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            subway[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            subway[x].add(y);
            subway[y].add(x);
        }

        //main
        //순환선 찾기
        dfs(0, 1);
        //각 역에서 순환선 거리구하기
        bfs();

        //output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
