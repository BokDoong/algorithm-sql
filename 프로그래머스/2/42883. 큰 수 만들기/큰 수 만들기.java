import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        // 스택에 하나씩 넣음
        // 새로운 값 vs top 비교
        // - 새로운 값이 top보다 작을 때까지 pop & 뺀수++, 앞이 클수록 이득이니까
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < c) {
                stack.pop();
                k -= 1;
            }
            stack.push(c);
        }
        
        
        // 넘는다면 뒤에서 짜르기
        while (k > 0) {
            stack.pop();
            k -= 1;
        }
        
         StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());  // 바닥에서부터 꺼냄
        }
        return sb.toString();
    }
}