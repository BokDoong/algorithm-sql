import java.util.*;

class Solution {
    
    class Node {
        
        int price;
        int idx;
        
        public Node(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            
            Node node = new Node(prices[i], i);
            
            while(!stack.isEmpty()) {
                if (stack.peek().price > prices[i]) {
                    Node popped = stack.pop();
                    answer[popped.idx] = i - popped.idx;
                } else {
                    break;
                }
            }
            
            stack.push(node);
        }
        
        while(!stack.isEmpty()) {
            Node popped = stack.pop();
            answer[popped.idx] = prices.length - popped.idx - 1;
        }
    
        return answer;
    }
}