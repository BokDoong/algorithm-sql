import java.io.*;
import java.util.*;

class Solution {
    
    public int calculate(int[] money, int start, int end) {
        
        int prev1 = 0;  // i-1 집
        int prev2 = 0;  // i-2 집
        
        for ( int i = start ; i <= end ; i++ ) {
            int cur = Math.max(prev2 + money[i], prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
        
    }
    
    public int solution(int[] money) {
        
        int n = money.length;
        
        int firstStolen = calculate(money, 0, n-2);
        int firstNotStolen = calculate(money, 1, n-1);
        
        return Math.max(firstStolen, firstNotStolen);
        
    }
}