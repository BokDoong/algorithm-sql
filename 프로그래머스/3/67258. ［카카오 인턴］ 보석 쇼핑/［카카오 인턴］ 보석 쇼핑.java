import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        // 결과
        int maxLeft = 0;
        int maxRight = gems.length;
        
        // 전체 개수
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        int uniqueCount = gemSet.size();
        
        // 포인터
        int left = 0;
        int right = 0;
        
        Set<String> inputGemSet = new HashSet<>();
        Map<String, Integer> inputGemCountMap = new HashMap<>();
        while (right < gems.length) {
            // 하나 넣고
            String targetGem = gems[right];
            inputGemSet.add(targetGem);
            if (inputGemCountMap.containsKey(targetGem)) {
                inputGemCountMap.put(targetGem, inputGemCountMap.get(targetGem) + 1);
            } else {
                inputGemCountMap.put(targetGem, 1);
            }
            
            // 가득차있다면 left ++
            while (inputGemSet.size() == uniqueCount) {
                
                if (right - left < maxRight - maxLeft) {
                    maxRight = right;
                    maxLeft = left;
                }
                
                int currentCount = inputGemCountMap.get(gems[left]);
                if (currentCount == 1) {
                    inputGemCountMap.remove(gems[left]);
                    inputGemSet.remove(gems[left]);
                } else {
                    inputGemCountMap.put(gems[left], currentCount - 1);
                }
                                                        
                left++;
            }
                   
            right++;
        }
        
        int[] answer = {maxLeft+1, maxRight+1};
        return answer;
    }
}