import java.util.*;
import java.io.*;

class Solution {
    
    class Job {
        
        int id;
        int requestTime;
        int takenTime;
        
        public Job(int id, int requestTime, int takenTime) {
            this.id = id;
            this.requestTime = requestTime;
            this.takenTime = takenTime;
        }
        
        @Override
        public String toString() {
            return "id : " + id + ", requestTime : " + requestTime + ", takenTime : " + takenTime;
        }
        
    }
    
    public int solve(int[][] jobs) {
        
        // 요청 시점 기준 정렬
        Arrays.sort(jobs, Comparator.comparingInt((int[] job) -> job[0]));
        
        // 최소힙 초기화
        PriorityQueue<Job> queue = new PriorityQueue<>(
            Comparator.comparingInt((Job job) -> job.takenTime)
                    .thenComparingInt(job -> job.requestTime)
                    .thenComparingInt(job -> job.id)
        );
        
        // 수행 개수, 총 반환시간, 큐에 넣은 윈도우
        int done = 0;
        int totalReturnTime = 0;
        int window = 0;
        int time = 0;
        
        // ㄱㄱ
        while ( done < jobs.length ) {
            
            // 시간 보다 작거나 같은 애들 window부터 쭉 넣기
            while ( true ) {
                
                // 마지막이라면 벗어나기
                if ( window == jobs.length) {
                    break;
                }
                
                // 작업 넣기
                int[] job = jobs[window];
                if ( job[0] <= time ) {
                    queue.add(new Job(window, job[0], job[1]));
                    window += 1;
                } else {
                    break;
                }
                
            }
            
            // 큐에 작업 남아있다면 수행 시간 만큼 점프 -> 반환시간, done 계산
            if ( !queue.isEmpty() ) {
                Job todo = queue.poll();
                time += todo.takenTime;
                done += 1;
                totalReturnTime += (time - todo.requestTime);
            } 
            // 아니라면 1초 증가
            else {
                time += 1;
            }
            
        }
        return totalReturnTime / jobs.length;
    }
    
    public int solution(int[][] jobs) {
        return solve(jobs);
    }
}