import java.util.*;

class Solution {
    public int solution(String name) {

        // 각 자리마다 얼마나 이동해야하는지 정하기 (세로 이동)
        int[] dist = new int[name.length()];
        for (int i = 0; i < name.length(); i++) {
            dist[i] = Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');
        }

        // System.out.println(Arrays.toString(dist));

        // 세로 이동 합 (A -> 각 알파벳)
        int answer = 0;
        for (int i = 0; i < dist.length; i++) {
            answer += dist[i];
        }

        // 한 자리라면 끝 (가로 이동 없음)
        if (name.length() == 1) {
            return answer;
        }

        // 가로 이동 최소값 구하기
        // 기본: 그냥 오른쪽으로 끝까지 가는 경우
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {

            // i 다음부터 연속된 A 구간 끝까지 스킵
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 케이스 1) 오른쪽으로 i까지 갔다가 되돌아오고(턴) -> 뒤쪽 처리
            // 오른쪽 i + 되돌아 i + (끝에서 next까지)
            int case1 = i * 2 + (name.length() - next);

            // 케이스 2) 뒤쪽(왼쪽) 먼저 갔다가 -> 다시 오른쪽 처리
            // (끝에서 next까지)*2 + i
            int case2 = (name.length() - next) * 2 + i;

            move = Math.min(move, Math.min(case1, case2));
        }

        return answer + move;
    }
}