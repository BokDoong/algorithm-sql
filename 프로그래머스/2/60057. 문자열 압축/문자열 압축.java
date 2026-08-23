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
                if (splitted.get(i).equals(prev)) {
                    count++;
                } else {
                    // 런 정산 — 닫히는 런(prev)의 실제 길이로
                    tmpAnswer += prev.length() + (count > 1 ? String.valueOf(count).length() : 0);
                    count = 1;
                    prev = splitted.get(i);
                }
            }
            // 마지막 런 정산 (꼬리 조각이면 prev.length()가 unit보다 짧을 수 있음)
            tmpAnswer += prev.length() + (count > 1 ? String.valueOf(count).length() : 0);

            answer = Math.min(answer, tmpAnswer);
        }
        return answer;
    }

    private List<String> split(String s, int unit) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i += unit) {
            answer.add(s.substring(i, Math.min(i + unit, s.length())));
        }
        return answer;
    }
}