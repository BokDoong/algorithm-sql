import java.io.*;
import java.util.*;

class Solution {
    
    public long binarySearch(long maxTime, int[] times, int n) {
        
        long left = 0;
        long right = maxTime;
        long targetTime = ( left + right ) / 2;
        
        while ( left < right ) {
            
            targetTime = ( left + right ) / 2;
            long judges = calculateJudgeHuman(times, targetTime);
            
            if ( judges < n ) {
                left = targetTime + 1;
            } else {
                right = targetTime;
            }
            
        }
        
        return left; 
        
    }
    
    public int calculateLongestTime(int[] times) {
        
        int result = -1;
        
        for ( int i = 0 ; i < times.length ; i++ ) {
            result = Math.max(result, times[i]);
        }
        
        return result;
        
    }
    
    public long calculateJudgeHuman(int[] times, long targetTime) {
        
        long judge = 0;
        
        for ( int i = 0 ; i < times.length ; i++ ) {
            judge += (long)(targetTime / times[i]);
        }
        
        return judge;
        
    }
    
    public long solution(int n, int[] times) {
        long maxTime = calculateLongestTime(times) * (long) n;
        return binarySearch(maxTime, times, n);
    }
    
}