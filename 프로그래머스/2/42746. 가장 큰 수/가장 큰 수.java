import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int n = 0; n < numbers.length; n++) {
            arr[n] = String.valueOf(numbers[n]);
        }
        
        Arrays.sort(arr, Comparator.comparing((String s) -> s.concat(s).concat(s)));

        StringBuilder sb = new StringBuilder();
        for (int n = arr.length-1; n > -1; n--) {
            sb.append(arr[n]);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}