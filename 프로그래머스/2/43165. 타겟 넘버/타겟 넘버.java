import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers.length, 0, 0, target, numbers);
        return answer;
    }
    
    // input : 젼체 인덱스, 현재 인덱스, 값
    // output : X
    // 동작
    // - 인덱스가 마지막이고 값이 타겟이면 값 갱신 + 바로 리턴
    // - 다음 +/-로 재귀
    void dfs(int totalIdx, int nowIdx, int value, int target, int[] numbers) {
        if (totalIdx == nowIdx) {
            if (target == value) {
                answer += 1;
            }
            return;
        }
        dfs(totalIdx, nowIdx + 1, value + numbers[nowIdx], target, numbers);
        dfs(totalIdx, nowIdx + 1, value - numbers[nowIdx], target, numbers);
    }
}