import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = s.length();
        
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int tmpAnswer = 0;
            
            // 앞에서 부터 unit마다 잘라서 -> 리스트에 넣기
            List<String> nums = new ArrayList<>();
            int idx = 0;
            while (idx < s.length()) {
                if (idx + unit > s.length()) nums.add(s.substring(idx, s.length()));
                else nums.add(s.substring(idx, idx+unit));
                idx += unit;
            }
            
            // 하나씩 돌아가면서 이전이랑 같은지 보기 -> 같다면 count++ -> 다르다면 count가 1이면 그대로, 1보다 크면 1+단위
            String prev = "";
            int cnt = 0;
            for (String num : nums) {
                if (num.equals(prev)) {
                    cnt++;
                } else {
                    if (cnt >= 1) tmpAnswer += prev.length() + (cnt > 1 ? String.valueOf(cnt).length() : 0);
                    prev = num;
                    cnt = 1;
                }
            }
            tmpAnswer += prev.length() + (cnt > 1 ? String.valueOf(cnt).length() : 0);
            answer = Math.min(answer, tmpAnswer);
        }
        
        return answer;
    }
}