import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int unit = 1; unit <= s.length() / 2; unit++) {
            List<String> splitted = split(s, unit);

            String prev = splitted.get(0);
            int count = 1;
            int tmpAnswer = 0;
            for (int i = 1; i < splitted.size(); i++) {
                if (prev.equals(splitted.get(i))) {
                    count++;
                } else {
                    // 런 정산 — 닫히는 런(prev)의 실제 길이 + 반복 시 자릿수
                    tmpAnswer += prev.length() + (count > 1 ? String.valueOf(count).length() : 0);
                    count = 1;
                    prev = splitted.get(i);
                }
            }
            // 마지막 런 정산
            tmpAnswer += prev.length() + (count > 1 ? String.valueOf(count).length() : 0);

            answer = Math.min(answer, tmpAnswer);
        }
        return answer;
    }

    private List<String> split(String s, int unit) {
        List<String> answer = new ArrayList<>();
        int idx = 0;
        while (idx + unit <= s.length()) {
            answer.add(s.substring(idx, idx + unit));
            idx += unit;
        }
        if (idx < s.length()) answer.add(s.substring(idx));
        return answer;
    }
}