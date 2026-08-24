import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String, String> nicknames = new HashMap<>();
        List<String[]> logs = new ArrayList<>();   // [uid, 메시지 접미사]

        for (String r : record) {
            String[] splitted = r.split(" ");
            if (!splitted[0].equals("Leave")) nicknames.put(splitted[1], splitted[2]);   // Enter, Change
            if (splitted[0].equals("Leave")) logs.add(new String[]{splitted[1], "님이 나갔습니다."});
            else if (splitted[0].equals("Enter")) logs.add(new String[]{splitted[1], "님이 들어왔습니다."});
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nicknames.get(logs.get(i)[0]) + logs.get(i)[1];
        }
        return answer;
    }
}