import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push('(');
            else {
                if (stack.isEmpty()) return false;   // 짝 없는 ')' 
                stack.pop();
            }
        }
        return stack.isEmpty();   // 닫히지 않은 '(' 검사
    }
}