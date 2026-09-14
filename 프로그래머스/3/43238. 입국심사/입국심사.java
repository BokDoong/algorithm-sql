import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[0]*n;
        
        while (left < right) {
            long mid = (left + right) / 2;
            if (enough(mid, times, n)) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
    
    boolean enough(long t, int[] times, int n) {
        long done = 0;
        for (int time : times) {
            done += t/time;
            if (done >= n) return true;
        }
        return false;
    }
}