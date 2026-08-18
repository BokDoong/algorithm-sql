import java.util.*;

class Solution {
    public int solution(String name) {
        
        int answer = 0;
        
        // 각 자리수
        for (char c : name.toCharArray()) {
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 쭉 이동
        int move = name.length() - 1;
        
        // 인덱스 하나씩 기준으로
        for (int i = 0; i < name.length(); i++) {
            // A가 연속으로 오는 첫 인덱스 찾기
            int idx = i + 1;
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }
            
            // i까지 -> 역순
            move = Math.min(move, 2*i + name.length() - idx);
            
            // 역순 -> i까지
            move = Math.min(move, 2*(name.length() - idx) + i);
        }        
        
        answer += move;
        return answer;
    }
}