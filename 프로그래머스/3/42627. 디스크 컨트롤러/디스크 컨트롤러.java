import java.util.*;
import java.io.*;

class Solution {
    
//     public void debug() {
        
//     }
    
    class Job {
        
        int id;
        int requestTime;
        int executionTime;
        
        public Job(int id, int requestTime, int executionTime) {
            this.id = id;
            this.requestTime = requestTime;
            this.executionTime = executionTime;
        }
        
        @Override
        public String toString() {
            return "id : " + id + ", requestTime : " + requestTime + ", executionTime : " + executionTime;
        }
        
    }
    
    // 대기큐 최소힙 : jobs의 job들을 넣고 기다리는 최소힙, 요청들어온 시간 기준 정렬
    public PriorityQueue<Job> waitingJobs = new PriorityQueue<>(
        Comparator.comparingInt((Job job) -> job.requestTime)
    );
    // 수행큐 최소힙 : 작업 소요시간 -> 요청시각 -> 작업 번호 순으로 정렬
    public PriorityQueue<Job> todoJobs = new PriorityQueue<>(
        Comparator
            .comparingInt((Job job) -> job.executionTime)
            .thenComparingInt(job -> job.requestTime)
            .thenComparingInt(job -> job.id)
    );
    
    // jobs -> 대기큐에 넣기
    public void initialize(int[][] jobs) {
        for (int i = 0; i < jobs.length; i++) {
            Job job = new Job(i, jobs[i][0], jobs[i][1]);
            waitingJobs.add(job);
        }
    }
    
    // 1초 카운팅하며 순회 : 대기큐에서 현재 시간보다 적은 태스크들 수행큐에 넣기 -> 수행할 것 있다면 수행 + 시간 뻥튀기 & 아니라면 +1초
    public int solve(int n) {
        
        int result = 0;
        int sec = 0;
        
        while (!waitingJobs.isEmpty()) {
            
            // 지금 시간보다 요청시간이 작다면 넣기
            while (true) {
                
                Job newJob = waitingJobs.peek();
                if (newJob == null) break;
                
                if (newJob.requestTime <= sec) {
                    todoJobs.add(waitingJobs.poll());
                } else {
                    break;
                }
            }
            
            // 할거 있다면 수행 아니면 sec + 1
            if (!todoJobs.isEmpty()) {
                Job todo = todoJobs.poll();
                sec += todo.executionTime;
                result += (sec - todo.requestTime);
            } else {
                sec += 1;
            }
        }
        
        // 잔존 태스크 처리
        while (!todoJobs.isEmpty()) {
            Job todo = todoJobs.poll();
            sec += todo.executionTime;
            result += (sec - todo.requestTime);
        }
        
        return (int) result / n;
    }
    
    public int solution(int[][] jobs) {
        initialize(jobs);
        return solve(jobs.length);
    }
}