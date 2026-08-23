import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // Map<String(능력), List<점수>>
        Map<String, List<Integer>> map = initInfos(info);

        // 이분 탐색을 위해 각 점수 리스트 정렬
        for (String key : map.keySet()) Collections.sort(map.get(key));

        // query 순회 — '-'는 후보 알파벳으로 확장 후 각 key에서 누적
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            int target = Integer.parseInt(q.split(" ")[7]);
            int tmpAnswer = 0;
            for (String key : normalize(q)) {
                List<Integer> scores = map.get(key);
                if (scores == null) continue;
                tmpAnswer += scores.size() - find(scores, target);
            }
            answer[i] = tmpAnswer;
        }
        return answer;
    }

    // lower bound: target 이상이 처음 나오는 위치
    private int find(List<Integer> array, int target) {
        int left = 0;
        int right = array.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (array.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // "- and backend and senior and - 150" → 후보 key 목록
    private List<String> normalize(String q) {
        String[] splitted = q.split(" ");
        List<String> answer = new ArrayList<>();

        // cpp, java, python, -
        String skill = splitted[0];
        if (skill.equals("-")) {
            answer.add("c");
            answer.add("j");
            answer.add("p");
        } else {
            answer.add(String.valueOf(skill.charAt(0)));
        }

        // backend, frontend, -
        List<String> tmpAnswer = new ArrayList<>();
        String part = splitted[2];
        if (part.equals("-")) {
            for (String a : answer) {
                tmpAnswer.add(a + "b");
                tmpAnswer.add(a + "f");
            }
        } else {
            for (String a : answer) {
                tmpAnswer.add(a + part.charAt(0));
            }
        }
        answer = tmpAnswer;

        // junior, senior, -
        tmpAnswer = new ArrayList<>();
        String grade = splitted[4];
        if (grade.equals("-")) {
            for (String a : answer) {
                tmpAnswer.add(a + "j");
                tmpAnswer.add(a + "s");
            }
        } else {
            for (String a : answer) {
                tmpAnswer.add(a + grade.charAt(0));
            }
        }
        answer = tmpAnswer;

        // chicken, pizza, -
        tmpAnswer = new ArrayList<>();
        String food = splitted[6];
        if (food.equals("-")) {
            for (String a : answer) {
                tmpAnswer.add(a + "c");
                tmpAnswer.add(a + "p");
            }
        } else {
            for (String a : answer) {
                tmpAnswer.add(a + food.charAt(0));
            }
        }
        answer = tmpAnswer;
        return answer;
    }

    // "java backend junior pizza 150" → 능력 key로 축약해 점수 적재
    private Map<String, List<Integer>> initInfos(String[] infos) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String info : infos) {
            String[] splitted = info.split(" ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) sb.append(splitted[i].charAt(0));

            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>())
               .add(Integer.parseInt(splitted[4]));
        }
        return map;
    }
}