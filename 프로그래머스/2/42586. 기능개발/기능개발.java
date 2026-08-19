import java.util.*;

class Solution {
    // [93, 30, 55] -> (100-progresses[i])/speeds[i]) + 나머지 있으면 1 -> [7, 3, 9]
    // 큐에 넣어서 -> "하나빼고 -> 큰게 나올 때까지 pop -> answer++" 반복
    public int[] solution(int[] progresses, int[] speeds) {
      
      int[] jobs = new int[progresses.length];
      for (int i = 0; i < progresses.length; i++) {
        jobs[i] = (int) ((100-progresses[i]) / speeds[i]);
        if (((100-progresses[i]) % speeds[i]) > 0) jobs[i]++;
      }
      
      List<Integer> answer = new ArrayList<>();

      int idx = 0;
      while (idx < jobs.length) {
        int target = jobs[idx];
        int tmpAnswer = 1;
        idx++;

        while (idx < jobs.length && jobs[idx] <= target) {
          idx++;
          tmpAnswer++;
        }

        answer.add(tmpAnswer);
      }

      return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}