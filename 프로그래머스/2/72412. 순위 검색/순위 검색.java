import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        // 능력 key → 점수 리스트
        Map<String, List<Integer>> abilities = new HashMap<>();
        for (String in : info) {
            String[] sp = in.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) sb.append(sp[i].charAt(0));
            abilities.computeIfAbsent(sb.toString(), k -> new ArrayList<>())
                     .add(Integer.parseInt(sp[4]));
        }

        // 이진 탐색을 위해 각 리스트 정렬
        for (List<Integer> list : abilities.values()) Collections.sort(list);

        // 쿼리: '-'를 확장한 key들 각각에서 target 이상 인원 합산
        int[] answer = new int[query.length];
        for (int q = 0; q < query.length; q++) {
            int target = normalizeScore(query[q]);
            int count = 0;
            for (String key : normalizeAbility(query[q])) {
                List<Integer> list = abilities.get(key);
                if (list == null) continue;
                count += list.size() - lowerBound(list, target);
            }
            answer[q] = count;
        }
        return answer;
    }

    // java and backend and junior and pizza 100 → [jbjp] / '-'는 후보로 확장
    private List<String> normalizeAbility(String query) {
        String[] commands = query.split(" ");
        List<String> answer = new ArrayList<>();

        // 개발언어
        String language = commands[0];
        if (language.equals("-")) {
            answer.add("c"); answer.add("j"); answer.add("p");   // cpp, java, python
        } else {
            answer.add(String.valueOf(language.charAt(0)));
        }

        // 직군
        String position = commands[2];
        List<String> next = new ArrayList<>();
        if (position.equals("-")) {
            for (String a : answer) {
                next.add(a + "b");
                next.add(a + "f");
            }
        } else {
            for (String a : answer) {
                next.add(a + position.charAt(0));
            }
        }
        answer = next;

        // 경력
        String career = commands[4];
        next = new ArrayList<>();
        if (career.equals("-")) {
            for (String a : answer) {
                next.add(a + "j");
                next.add(a + "s");
            }
        } else {
            for (String a : answer) {
                next.add(a + career.charAt(0));
            }
        }
        answer = next;

        // 소울푸드
        String food = commands[6];
        next = new ArrayList<>();
        if (food.equals("-")) {
            for (String a : answer) {
                next.add(a + "c");
                next.add(a + "p");
            }
        } else {
            for (String a : answer) {
                next.add(a + food.charAt(0));
            }
        }
        answer = next;
        return answer;
    }

    private int normalizeScore(String query) {
        String[] splitted = query.split(" ");
        return Integer.parseInt(splitted[splitted.length - 1]);
    }

    // list에서 target 이상이 처음 나오는 위치 (lower bound)
    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}