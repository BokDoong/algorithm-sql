import java.util.*;

class Solution {
    
    // 부모 노드 정보
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        
        // 부모 노드
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        // 비용 기준으로 정렬: 최대한 낮은 비용인 애들부터 갖고오기 위해
        // 두 노드가 그룹이 되면 앞으로 해당 노드가 나오면 볼 필요가 없음
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int answer = 0, picked = 0;
        for (int[] e : costs) {
            // 다른 그룹이면 합치고 더함
            // 같은 그룹이면 이미 최소 비용을 알기 떄문에 알 필요가 없음.
            if (find(e[0]) != find(e[1])) {
                union(e[0], e[1]);
                answer += e[2];
                picked++;
                if (picked == n-1) break;
            }
        }
        
        return answer;
    }
    
    // 부모 찾기
    int find(int node) {
        if (parents[node] == node) return node;
        return find(parents[node]);
    }
    
    // 합치기
    void union(int node1, int node2) {
        parents[find(node2)] = find(node1);
    }
}