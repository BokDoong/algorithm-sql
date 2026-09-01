import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        
        while (left < right) {
            long mid = (left + right) / 2;
            
            long total = 0;
            for (int time : times) {
                total += mid/time;
            }
            
            if (total >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}