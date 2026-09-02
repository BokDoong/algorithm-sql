import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        // 전체 알파벳의 종류
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        int n = set.size();
        
        // right를 0 ~ n-1 인덱스로 하나씩 늘려가며
        int left = 0;
        int maxLength = Integer.MAX_VALUE, maxLeft = 0;
        Map<String, Integer> gemCount = new HashMap<>();
        for (int right = 0; right < gems.length; right++) {
            
            String gem = gems[right];
            
            // right의 원소를 추가
            if (!gemCount.containsKey(gem)) {
                gemCount.put(gem, 1);
            } else {
                gemCount.put(gem, gemCount.get(gem) + 1);
            }
            
            // 지금 추가한 원소의 종류가 전체 알파벳 종류와 같다면 + while
            while (gemCount.size() == n) {
                
                // (right - left + 1)이 현재 길이보다 작다면 갱신
                if (right - left + 1 < maxLength) {
                    maxLength = right - left + 1;
                    maxLeft = left;
                }
                
                // 빼기
                String leftGem = gems[left];
                if (gemCount.get(leftGem) == 1) {
                    gemCount.remove(leftGem);
                } else {
                    gemCount.put(leftGem, gemCount.get(leftGem) - 1);
                }
                
                left++;
            }
            
        }
        
        return new int[]{maxLeft + 1, maxLeft + maxLength};
    }
}