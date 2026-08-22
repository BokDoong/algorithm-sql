import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> tokens1 = tokenize(str1);
        List<String> tokens2 = tokenize(str2);

        // str1의 다중집합 카운트
        Map<String, Integer> counts = new HashMap<>();
        for (String t : tokens1) counts.put(t, counts.getOrDefault(t, 0) + 1);

        // 교집합: str2를 순회하며 남은 카운트에서 차감
        int common = 0;
        Map<String, Integer> remaining = new HashMap<>(counts);
        for (String t : tokens2) {
            Integer val = remaining.get(t);
            if (val != null) {
                common++;
                if (val == 1) remaining.remove(t);
                else remaining.put(t, val - 1);
            }
        }

        // 다중집합 공식: |A ∪ B| = |A| + |B| - |A ∩ B|
        int union = tokens1.size() + tokens2.size() - common;
        if (union == 0) return 65536;   // 둘 다 유효 토큰 없음 → 유사도 1
        return 65536 * common / union;  // int 나눗셈이라 버림 공짜
    }

    // 두 글자씩 자르면서 영문자 쌍만 소문자로 수집
    private List<String> tokenize(String str) {
        List<String> tokens = new ArrayList<>();
        String s = str.toLowerCase();
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i), b = s.charAt(i + 1);
            if (a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
                tokens.add(s.substring(i, i + 2));
            }
        }
        return tokens;
    }
}