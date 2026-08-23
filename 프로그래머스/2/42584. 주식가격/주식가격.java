import java.util.*;

class Solution {
    
  public int[] solution(int[] prices) {
   
    int[] answer = new int[prices.length];

    // 스택, new
    // 0번 : val, 1번 : 인덱스
    Deque<int[]> stack = new ArrayDeque<>();
    for (int i = 0; i < prices.length; i++) {
        // 비어있으면 끝
        if (stack.isEmpty()) {
            stack.push(new int[]{prices[i], i});
            continue;
        }
        // top이 new보다 값이 크다면 answer[top.idx] = (new.idx - top.idx)
        while (!stack.isEmpty() && stack.peek()[0] > prices[i]) {
            int[] top = stack.pop();
            answer[top[1]] = i - top[1];
        }
        
        stack.push(new int[]{prices[i], i});
    }

    // 남아있는 애들 : answer[remains.idx] = (prices.length - remains.idx)
    while (!stack.isEmpty()) {
        int[] top = stack.pop();
        answer[top[1]] = prices.length - top[1] - 1;
    }

    return answer;
  }
    
}