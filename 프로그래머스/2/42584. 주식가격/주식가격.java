import java.util.*;

class Solution {
    
  public int[] solution(int[] prices) {
   
    int[] answer = new int[prices.length];

    //  하나씩 스택에 넣는다
    //  -> Stack<int[]> stack, 0번 : 인덱스 위치, 1번 : 원소
    Deque<int[]> stack = new ArrayDeque<>();

    for (int i = 0; i < prices.length; i++) {
      
      // 비면 바로 넣고      
      if (stack.isEmpty()) {
        stack.push(new int[]{i, prices[i]});
        continue;
      }
      
      //  top이 나보다 크면 answer의 top 인덱스에 (나의 인덱스 - top의 인덱스) + pop
      //  top이 나보다 작거나 같을 때까지
      while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
        int[] val = stack.pop();
        answer[val[0]] = i - val[0];
      }
      
      // 넣고
      stack.push(new int[]{i, prices[i]});
    }

    //  남아있는 애는 prices.length - 1 - 인덱스
    while (!stack.isEmpty()) {
      int[] val = stack.pop();
      answer[val[0]] = prices.length - 1 - val[0];
    }

    return answer;
  }
}