import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = s.length();                          // ④ 해결

        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int compressed = 0;
            String prev = s.substring(0, unit);
            int count = 1;

            for (int i = unit; i < s.length(); i += unit) {
                String cur = s.substring(i, Math.min(i + unit, s.length()));  // ① 해결
                if (cur.equals(prev)) count++;
                else {
                    compressed += prev.length() + (count > 1 ? String.valueOf(count).length() : 0);  // ③
                    prev = cur;
                    count = 1;
                }
            }
            compressed += prev.length() + (count > 1 ? String.valueOf(count).length() : 0);  // ② 마지막 런 닫기

            answer = Math.min(answer, compressed);
        }
        return answer;
    }
}