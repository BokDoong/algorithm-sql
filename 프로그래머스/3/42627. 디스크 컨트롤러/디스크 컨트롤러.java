import java.util.*;
import java.io.*;

class Solution {
    
    public void debug() {
        
        for ( Integer t : jobMap.keySet() ) {
            System.out.print(t + " -> ");
            List<Job> jobList = jobMap.get(t);
            for ( Job job : jobList ) {
                System.out.print(job);
            }
            System.out.println();
        }
        
    }
    
    HashMap<Integer, List<Job>> jobMap = new HashMap<>();
    PriorityQueue<Job> heap = new PriorityQueue<>(1, new JobComparator());
    List<Integer> returnTimes = new ArrayList<>();
    
    class Job {
        
        int idx;
        int requestTime;
        int takenTime;
        
        public Job ( int idx, int requestTime, int takenTime ) {
            this.idx = idx;
            this.requestTime = requestTime;
            this.takenTime = takenTime;
        }
        
        public int calculateReturnTimes(int endTime) { 
            return endTime - requestTime;
        }
        
        @Override
        public String toString() {
            return "idx : " + idx + ", requestTime : " + requestTime + ", takenTime : " + takenTime;
        }
        
    }
    
    class JobComparator implements Comparator<Job> {
        
        @Override
        public int compare(Job j1, Job j2) {
            if ( j1.takenTime == j2.takenTime && j1.requestTime == j2.requestTime ) {
                return j1.idx - j2.idx;
            } else if ( j1.takenTime == j2.takenTime ) {
                return j1.requestTime - j2.requestTime;
            } else {
                return j1.takenTime - j2.takenTime;
            }
        }
        
    }
    
    public void inputToMap(int[][] jobs) {
        
        for ( int i = 0 ; i < jobs.length ; i++ ) {
            
            Job job = new Job(i, jobs[i][0], jobs[i][1]);
            
            if (!jobMap.containsKey(jobs[i][0])) {
                List<Job> jobList = new ArrayList<>();
                jobList.add(job);
                jobMap.put(jobs[i][0], jobList);
            } else {
                List<Job> jobList = jobMap.get(jobs[i][0]);
                jobList.add(job);
            }
            
        }
        
    }
    
    public void solve(int[][] jobs) {
        
        // 첫 요청시간 부터
        int time = jobs[0][0];
        
        // 수행
        while ( returnTimes.size() < jobs.length ) {
            
            // 현재 시간에서 수행할 작업 넣기
            if ( jobMap.containsKey(time) ) {
                List<Job> firstJobs = jobMap.get(time);
                for ( Job job : firstJobs ) {
                    heap.add(job);
                }
            }
            
            // 수행할 업무가 있다면 
            if ( !heap.isEmpty() ) {
                
                Job todoJob = heap.poll();   
                
                // 작업이 끝나는 시간까지 들어오는 데이터힙에 추가
                int endTime = time + todoJob.takenTime;
                for ( int t = time+1 ; t < endTime ; t++ ) {
                    if ( jobMap.containsKey(t) ) {
                        List<Job> requestedJobs = jobMap.get(t);
                        for ( Job job : requestedJobs ) {
                            heap.add(job);
                        }
                    }
                }
                
                // 반환 시간 계산
                Integer returnTime = todoJob.calculateReturnTimes(endTime);
                returnTimes.add(returnTime);
                
                // 다음 시간으로 
                time = endTime;
                
            } else {
                
                // 해야할 일 없다면 시간 지나가기
                time++;
                
            }
            
        }
        
    }
    
    public int calculateAverageReturnTimes() {
        Integer result = 0;
        for ( Integer returnTime : returnTimes ) {
            result += returnTime;
        }
        return (int) result.intValue() / returnTimes.size();
    }

    
    public int solution(int[][] jobs) {
        
        // 요청시간 기준으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt((int[] job) -> job[0]));
        
        // 각 요청을 Map에 넣기
        inputToMap(jobs);
        
        // 작업 수행
        solve(jobs);
        
        // 반환시간 평균 계산
        int answer = calculateAverageReturnTimes();
        return answer;
        
    }
}