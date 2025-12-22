import java.io.*;
import java.util.*;

class Solution {
    
    int result = -1;
    int totalSize = -1;
    
    public int backTracking(boolean[] visited, int explored, int remains, int[][] dungeons) {
        
        // 결과 업데이트
        result = Math.max(result, explored);
        
        // 순회하면서 방문할 수 있는지 보기
        for ( int i = 0 ; i < totalSize ; i++ ) {
            
            // 이미 방문했다면 넘기기
            if ( visited[i] ) {
                continue;
            }
            
            // 최소 피로도 조건 안되면 넘기기
            if ( dungeons[i][0] > remains ) {
                continue;
            }
            
            // 백트래킹
            visited[i] = true;
            backTracking(visited, explored + 1, remains - dungeons[i][1], dungeons);
            visited[i] = false;
            
        }
        
        return 0;
        
    }
    
    public int solution(int k, int[][] dungeons) {
        
        // 초기화
        totalSize = dungeons.length;
        boolean[] visited = new boolean[totalSize];
        
        // 백트래킹
        backTracking(visited, 0, k, dungeons);
        return result;
    }
    
}