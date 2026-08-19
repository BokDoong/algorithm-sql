import java.util.*;

class Solution {
    boolean solution(String s) {
    
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == ')') {
        if (stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      } else {
        stack.push('(');
      }
    }

    if (!stack.isEmpty()) return false;
    
    return true;
  }
}