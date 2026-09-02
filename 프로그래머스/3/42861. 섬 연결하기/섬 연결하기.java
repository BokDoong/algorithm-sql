import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {

        // 부모
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        // 거리순으로 정렬하기
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int picked = 0;
        int answer = 0;
        for (int[] cost : costs) {
            // 다른 그룹이라면 union
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                picked++;
                answer += cost[2];
            }
            // 그룹 내 개수 체크
            if (picked == n-1) {
                return answer;
            }
        }
        
        return answer;
    }
    
    int find(int node) {
        if (parent[node] == node) return node;
        return find(parent[node]);
    }
    
    void union(int node1, int node2) {
        parent[find(node2)] = find(node1);
    }
}