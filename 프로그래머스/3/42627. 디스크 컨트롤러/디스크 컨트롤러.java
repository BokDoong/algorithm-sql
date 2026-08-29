import java.util.*;

class Solution {
    
    // [요청 시간, 소요 시간]
    public int solution(int[][] jobs) {
        int n = jobs.length;
        
        // 요청시간 기준 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        // 실행후보 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0;
        int idx = 0;        // 도착 처리하지 않은 작업의 인덱스
        int done = 0;
        int total = 0;
        
        while (done < n) {
            // 도착한 작업 후보에 넣기
            while (idx < n && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            
            // 후보 없으면 다음 시간으로
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            // 가장 짧은 작업
            int[] job = pq.poll();
            time += job[1];
            total += time - job[0];
            done++;
        }
        
        return total / n;
    }
}