import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        int answer = 0;
        parent = new int[n];
        
        // 비용순 정렬
        Arrays.sort(costs, (cost1, cost2) -> cost1[2] - cost2[2]);
        
        // 초기화
        init(n);
        
        // 유니온 & 파인드 : 어차피 같은 그룹이면 간선이 안만들어짐
        int edges = 0;
        for (int[] cost : costs) {
            // 간선의 개수가 n-1이 될 때까지 순회
            if (edges == n-1) break;
            
            // 같은 그룹인지 보고 > 아니라면 합치기, 비용 더하기
            if (union(cost[0], cost[1])) {
                answer += cost[2];
                edges++;
            }
        }
        
        return answer;
    }
    
    void init(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    int findRoot(int node) {
        if (parent[node] == node) return node;
        parent[node] = findRoot(parent[node]);
        return parent[node];
    }
    
    boolean union(int nodeA, int nodeB) {
        int rootA = findRoot(nodeA);
        int rootB = findRoot(nodeB);
        // 같은 그룹
        if (rootA == rootB) return false;
        // 합치기
        parent[rootA] = rootB;
        return true;
    }
}