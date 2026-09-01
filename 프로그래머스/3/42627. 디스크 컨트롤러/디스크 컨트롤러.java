import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        
        // 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 힙
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // 변수
        int total = 0;
        int time = 0;
        int idx = 0;
        int n = jobs.length;
        
        // 작업
        while (idx < n || !heap.isEmpty()) {
            
            System.out.println("time : " + time + ", idx : " + idx);
            
            // 힙에 넣기
            while (idx < n && jobs[idx][0] <= time) {
                heap.add(jobs[idx]);
                idx++;
            }
            
            System.out.println("time : " + time + ", idx : " + idx);
            
            // 힙이 비어있다면
            if (heap.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            // 힙이 차있다면, [요청 시간, 소요 시간]
            int[] todo = heap.poll();
            time = time + todo[1];
            total += time - todo[0];
            
            System.out.println(Arrays.toString(todo));
        }
        
        return total / n;
    }
    
}