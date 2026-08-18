import java.util.*;

class Solution {
    public String[] solution(String[] record) {

    // 임시 결과값
    List<String> tmpAnswers = new ArrayList<>();
    for (String inputs : record) {
      String[] input = inputs.split(" ");
      String command = input[0];
      if (command.equals("Enter")) tmpAnswers.add(input[1] + "님이 들어왔습니다.");
      else if (command.equals("Leave")) tmpAnswers.add(input[1] + "님이 나갔습니다.");
    }
    
    // 해시맵 - key: id, value: name
    HashMap<String, String> names = new HashMap<>();
    
    // 넣기
    for (String inputs : record) {
      String[] input = inputs.split(" ");
      String command = input[0];
      if (command.equals("Enter") || command.equals("Change")) names.put(input[1], input[2]);
    }

    // 출력
    List<String> answer = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (String tmpAnswer : tmpAnswers) {
      String[] splitted = tmpAnswer.split("님");
      sb.append(names.get(splitted[0])).append("님").append(splitted[1]);
      answer.add(sb.toString());
      sb = new StringBuilder();
    }

    // 디버깅
    String[] realAnswer = new String[answer.size()];
    for (int i = 0; i < answer.size(); i++) {
      realAnswer[i] = answer.get(i);
    }
    
    return realAnswer;
  }
}