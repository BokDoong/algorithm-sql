import java.util.*;

class Solution {
    // 캐시 사이즈 : 30, 도시 크기 : 10만 -> 300만 
    // 이미
    public int solution(int cacheSize, String[] cities) {

        Set<String> cityCaches = new HashSet<>();
        Map<String, Integer> indexCaches = new HashMap<>();
        int answer = 0;
        
        if (cacheSize == 0) return cities.length * 5;

        for (int i = 0; i < cities.length; i++) {
          String city = cities[i].toLowerCase();
          if (cityCaches.contains(city)) {
            answer++;
            indexCaches.put(city.toLowerCase(), i);
          } else {
            answer += 5;
            if (cacheSize <= cityCaches.size()) {
              String key = findLeastRecentlyUsedKey(indexCaches);
              cityCaches.remove(key);
              indexCaches.remove(key);
            }
            cityCaches.add(city.toLowerCase());
            indexCaches.put(city.toLowerCase(), i);
          }
        }

        return answer;
    }
    
    String findLeastRecentlyUsedKey(Map<String, Integer> indexCaches) {
        Integer minValue = Integer.MAX_VALUE;
        String answer = "";
        for (String key : indexCaches.keySet()) {
          if (indexCaches.get(key) < minValue) {
            minValue = indexCaches.get(key);
            answer = key;
          }
        }
        return answer;
    }
}