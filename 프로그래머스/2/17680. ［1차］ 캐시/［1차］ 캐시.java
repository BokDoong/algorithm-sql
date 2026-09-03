import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) return cities.length * 5;
        
        // 캐시
        Set<String> cache = new LinkedHashSet<>();
        int answer = 0;
        
        for (String city : cities) {
            // 소문자로 변환
            String key = city.toLowerCase();
            // 캐시에 이미 있으면 +1, 빼고 다시 넣기
            if (cache.contains(key)) {
                answer += 1;
                cache.remove(key);
                cache.add(key);
                continue;
            }
            
            // 캐시에 없으면
            // - 다 차있다면 맨 앞에꺼 제거
            // - 넣기
            if (cache.size() == cacheSize) {
                String oldest = cache.iterator().next();
                cache.remove(oldest);
            }
            cache.add(key);
            answer += 5;
        }
        
        return answer;
    }
}