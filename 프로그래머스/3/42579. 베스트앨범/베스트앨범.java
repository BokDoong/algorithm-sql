import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<int[]>> playsPerSong = new HashMap<>();

        // 집계: 장르별 총 재생수 + [인덱스, 재생수] 목록
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            totalPlays.put(genre, totalPlays.getOrDefault(genre, 0) + plays[i]);
            playsPerSong.computeIfAbsent(genre, k -> new ArrayList<>())
                        .add(new int[]{i, plays[i]});
        }

        // 장르 내부: 재생수 내림차순 > 인덱스 오름차순
        for (String key : playsPerSong.keySet()) {
            playsPerSong.get(key).sort((a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return a[0] - b[0];
            });
        }

        // 장르: 총 재생수 내림차순
        List<String> sortedGenres = new ArrayList<>(totalPlays.keySet());
        sortedGenres.sort((a, b) -> totalPlays.get(b) - totalPlays.get(a));

        // 장르당 최대 2곡
        List<Integer> answer = new ArrayList<>();
        for (String key : sortedGenres) {
            List<int[]> songs = playsPerSong.get(key);
            answer.add(songs.get(0)[0]);
            if (songs.size() > 1) answer.add(songs.get(1)[0]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}