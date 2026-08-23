import java.util.*;

class Solution {
    // 캐시 사이즈 : 30, 도시 크기 : 10만 -> 300만 
    // 이미
    public int solution(int cacheSize, String[] cities) {
        
        // 0개라면 바로 리턴
        if (cacheSize == 0) return 5 * cities.length;
        
        Set<String> cache = new LinkedHashSet<>();
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            boolean cacheHit = cache.contains(city);
            if (cacheHit) {
                cache.remove(city);
                cache.add(city);
                answer++;
            }
            else {
                if (cache.size() >= cacheSize) cache.remove(cache.iterator().next());
                cache.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}