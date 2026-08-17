import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length - 1;
        
        while (light <= heavy) {
            // 가벼운 light 태울 수 있으면 태우기
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            // 무거운 사람은 무조건 탑승
            heavy--;
            answer++;
        }
        
        return answer;
    }
}