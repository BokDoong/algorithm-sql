import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 하나씩 순회하며 자를 wire 구하기
        for (int cut = 0; cut < wires.length; cut++) {
            
            // 트리 > List
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            
            // 자를 두 노드는 제외하고 트리(List) 구성
            for (int i = 0; i < wires.length; i++) {
                if (i == cut) continue;
                tree.get(wires[i][0]).add(wires[i][1]);
                tree.get(wires[i][1]).add(wires[i][0]);
            }
            
            // 갱신
            int cnt1 = count(tree, wires[cut][0], n);
            int cnt2 = count(tree, wires[cut][1], n);
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
        }
        
        return answer;
    }
    
    private int count(List<List<Integer>> tree, int start, int n) {
        boolean[] visited = new boolean[n+1];
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(start);
        visited[start] = true;
        int count = 0;
        
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            count++;
            
            for (int next : tree.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
        return count;
    }
}