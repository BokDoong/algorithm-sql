import java.util.*;

class Solution {
    // Map<장르명, List<[재생횟수, 인덱스]>> 
    // Map<장르명, 총 재생 횟수> 
    Map<String, List<int[]>> genreMap = new HashMap<>();
    Map<String, Integer> playsPerGenre = new HashMap<>();
    
    // 구현 방법
    // - Value 기준 정렬해서 장르를 총 재생 횟수 순으로 정렬
    // - 장르마다 재생횟수 > 인덱스 기준으로 정렬해서 2개까지 뽑기
    public int[] solution(String[] genres, int[] plays) {
        
        // 데이터 넣기
        initialize(genres, plays);
        
        // 장르마다 재생횟수 > 인덱스 기준으로 정렬
        for (String key : genreMap.keySet()) {
            genreMap.get(key).sort((a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];
                return a[1] - b[1];
            });
        };
        
        // 장르마다 총 재생횟수 더해서 > Map에 넣고 > Value 기준으로 정렬하기
        calcuateTotalPlays();
        List<String> keys = playsPerGenre.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
            .map(Map.Entry::getKey)
            .toList();
        
        // 뽑기
        List<Integer> answer = new ArrayList<>();
        for (String key : keys) {
            List<int[]> values = genreMap.get(key);
            if (values.size() == 1) {
                answer.add(values.get(0)[1]);
            } else {
                answer.add(values.get(0)[1]);
                answer.add(values.get(1)[1]);
            }
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    void initialize(String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (genreMap.containsKey(genre)) genreMap.get(genre).add(new int[]{plays[i], i});
            else {
                genreMap.put(genre, new ArrayList<>());
                genreMap.get(genre).add(new int[]{plays[i], i});
            }
        }
    }
    
    void calcuateTotalPlays() {
        for (String key : genreMap.keySet()) {
            int total = 0;
            for (int[] value : genreMap.get(key)) total += value[0];
            playsPerGenre.put(key, total);
        }
    }
}