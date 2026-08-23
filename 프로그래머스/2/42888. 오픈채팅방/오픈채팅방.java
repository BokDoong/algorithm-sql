import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknames = new HashMap<>();

        // [uid, 메시지 접미사] — 닉네임은 마지막에 최종값으로 결합 (지연 포맷팅)
        List<String[]> logs = new ArrayList<>();
        for (String r : record) {
            String[] splitted = r.split(" ");
            // Leave가 아니면(Enter, Change) 닉네임 갱신
            if (!splitted[0].equals("Leave")) nicknames.put(splitted[1], splitted[2]);
            // Change는 로그를 남기지 않음
            if (splitted[0].equals("Enter")) logs.add(new String[]{splitted[1], "님이 들어왔습니다."});
            else if (splitted[0].equals("Leave")) logs.add(new String[]{splitted[1], "님이 나갔습니다."});
        }

        List<String> answer = new ArrayList<>();
        for (String[] log : logs) {
            answer.add(nicknames.get(log[0]) + log[1]);
        }
        return answer.toArray(new String[0]);
    }
}