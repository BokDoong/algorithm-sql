import java.io.*;
import java.util.*;

class Solution {
    
    public List<List<Integer>> graph = new ArrayList<>();
    
    // 0 : 연결O, N : 연결X + 연결되어 있는 노드 수
    public int checkConnectedOrConnect(int start, int end, int n) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        boolean[] visited = new boolean[n];
        visited[start] = true;
        
        while ( !queue.isEmpty() ) {
            
            Integer node = queue.poll();
            
            for ( Integer connectedNode : graph.get(node) ) {
                
                // 연결되어 있는지 확인
                if ( connectedNode == end ) {
                    return 0;
                }
                
                // 방문 안헀다면 방문
                if ( !visited[connectedNode] ) {
                    visited[connectedNode] = true;
                    queue.add(connectedNode);
                }
                
            }
            
        }
        
        // 연결 안되어 있었음
        // 연결
        graph.get(start).add(end);
        graph.get(end).add(start);

        // 최종 연결된 개수 리턴
        int result = 0;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( visited[i] ) {
                result += 1;
            }
        }
        
        return result;
    }
    
    public int solve(int n, int[][] costs) {
        
        int result = 0;
        
        for ( int i = 0 ; i < costs.length ; i++ ) {
            
            // 노드, 비용
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            
            // 연결되어 있는지 확인
            int connected = checkConnectedOrConnect(start, end, n);
            
            // 이미 연결되어 있으면 넘기기
            if ( connected == 0 ) {
                continue;
            }
            
            // 연결 다됐으면 끝
            result += cost;
            if ( connected == n ) {
                return result;
            }
            
        }
        
        return result;
        
    }
    
    public int[][] sortCosts(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt((int[] cost) -> cost[2]));
        return costs;
    }
    
    public void initialize(int n) {
        for ( int i = 0 ; i < n ; i++ ) {
            graph.add(new ArrayList<>());
        }
    }
    
    public int solution(int n, int[][] costs) {
        initialize(n);
        int[][] sortedCosts = sortCosts(costs);
        return solve(n, sortedCosts);
    }
}