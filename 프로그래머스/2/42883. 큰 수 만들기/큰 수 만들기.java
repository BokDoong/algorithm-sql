import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        // 스택에 넣기
        // 앞에 작은 수가 있다면 빼기 : k > 0 and 스택 안비었고 and peek이 나보다 작을 때
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // k가 남아있다면 뒤에서 빼기
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}