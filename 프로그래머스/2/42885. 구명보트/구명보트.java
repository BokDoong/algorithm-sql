import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        
        // 무거운 사람 태우고 > 가벼운 사람 태울 수 있으면 태우기
        int light = 0; int heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] <= limit - people[heavy]) {
                light++;
            }
            heavy--;
            answer++;
        }
        
        return answer;
    }
}