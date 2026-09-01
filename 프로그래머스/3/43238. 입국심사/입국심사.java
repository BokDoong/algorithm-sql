import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        // 느린 사람이 다 처리 
        long left = 0;
        long right = (long) times[times.length - 1] * n;
        
        // 이분탐색
        while (left < right) {
            long mid = (left + right) / 2;
            
            // 합 구하기
            long total = 0;
            for (int time : times) {
                total += mid/time;
            }
            
            // 이동
            if (total >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
            
        }
        
        return left;
    }
}