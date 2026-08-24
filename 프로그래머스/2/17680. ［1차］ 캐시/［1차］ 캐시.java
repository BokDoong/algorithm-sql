import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) return 5 * cities.length;

        Set<String> cache = new LinkedHashSet<>();
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                answer++;
                cache.remove(city);                       // 빼고 (아래서 다시 넣어 최신화)
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(cache.iterator().next()); // 가장 오래된 것 축출
                }
            }
            cache.add(city);                              // hit/miss 공통: 맨 뒤로
        }
        return answer;
    }
}