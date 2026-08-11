import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    int bfs(int[][] maps) {
        
        // 끝, 이동벡터
        int[] end = {maps.length - 1, maps[0].length - 1};
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        // 방문 배열
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        
        // 시작 좌표 큐에 넣기
        // 큐 : (x, y, 얼마나 이동했는지)
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = {0, 0, 1};
        queue.offer(start);
        
        // 큐 pop()
        // - 없으면 -1 리턴
        // - 있으면
        //    - 끝이라면 리턴
        //    - 주변 돌면서 갈 수 있는 곳 찾기(방문X, 안나갔는지, 비어있는지) > 갈 수 있음녀 큐에 넣기
        while (!queue.isEmpty()) {
            
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int value = node[2];
            
            if (x == end[0] && y == end[1]) {
                return node[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (canGo(maps, nextX, nextY, visited)) {
                    queue.offer(new int[]{nextX, nextY, value+1});
                    visited[nextX][nextY] = true;
                }
            }
            
        }
        
        return -1;
    }
    
    // 방문X, 안나갔는지, 비어있는지
    boolean canGo(int[][] maps, int nextX, int nextY, boolean[][] visited) {
        if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length) {
            return false;
        }
        if (visited[nextX][nextY]) {
            return false;
        }
        return maps[nextX][nextY] == 1;
    }
}