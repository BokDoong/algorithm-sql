import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        // 시작점 기준 정렬
        Arrays.sort(routes, (routeA, routeB) -> routeA[0] - routeB[0]);
        
        // 마킹
        int idx = 0;
        int answer = 0;
        while (idx < routes.length) {
            // 첫 마킹은 자동차 젤 끝
            int mark = routes[idx][1];
            idx++; 
            answer++;
            
            // 시작점이 이전 자동차의 끝 이전에 있는 애들 중 + 끝점이 가장 작은 애들
            while (idx < routes.length && routes[idx][0] <= mark) {
                mark = Math.min(mark, routes[idx][1]);
                idx++;
            }
        }
        
        return answer;
    }
}