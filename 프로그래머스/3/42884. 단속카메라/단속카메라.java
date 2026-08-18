import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        int answer = 0;
        
        // 시작점 기준 정렬
        Arrays.sort(routes, (route1, route2) -> route1[0] - route2[0]);
        
        // 순회
        int idx = 0;
        while (idx < routes.length) {            
            // 끝지점 마킹
            int marked = routes[idx][1];
            answer++;
            idx++;
            
            // 다음부터 start <= 끝지점 <= end 인 애들 지우기
            while (idx < routes.length && routes[idx][0] <= marked) {
                marked = Math.min(marked, routes[idx][1]);
                idx++;
            }
        }
        
        return answer;
    }
}