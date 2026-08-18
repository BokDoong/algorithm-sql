import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        // 정렬
        Arrays.sort(costs, (cost1, cost2) -> cost1[2] - cost2[2]);
        
        // 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // union-find
        int answer = 0;
        int v = 0;
        for (int[] cost : costs) {
            // 간선이 n-1개 될 때까지 합치기
            if (v == n-1) break;
            // 같은 그룹이면 합쳐지지 않음
            if (union(cost[0], cost[1])) {
                v++;
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    boolean union(int nodeA, int nodeB) {
        int rootA = findRoot(nodeA);
        int rootB = findRoot(nodeB);
        if (rootA != rootB) {
            parent[rootA] = rootB; 
            return true;
        }
        return false;
    }
    
    int findRoot(int node) {
        if (parent[node] == node) return node;
        parent[node] = findRoot(parent[node]);
        return parent[node];
    }
    
}