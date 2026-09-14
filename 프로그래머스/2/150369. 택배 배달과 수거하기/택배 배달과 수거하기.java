import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Queue<Integer> d = cut(deliveries, cap);
        Queue<Integer> p = cut(pickups, cap);

        long answer = 0;
        while (!d.isEmpty() || !p.isEmpty()) {
            int dd = d.isEmpty() ? 0 : d.poll();
            int pp = p.isEmpty() ? 0 : p.poll();
            answer += 2L * Math.max(dd, pp);
        }
        return answer;
    }

    // 뒤에서부터 cap씩 채워, 트립마다 "가장 먼 집 번호"를 순서대로 담는다
    Queue<Integer> cut(int[] nums, int cap) {
        Queue<Integer> trips = new ArrayDeque<>();
        int filled = 0;   // 현재 트립에 실은 양
        int far = 0;      // 현재 트립의 가장 먼 집 (1-based)

        for (int i = nums.length - 1; i >= 0; i--) {
            int amount = nums[i];
            while (amount > 0) {
                if (filled == 0) far = i + 1;            // 새 트립 시작 → 이 집이 가장 먼 집
                int take = Math.min(cap - filled, amount);
                filled += take;
                amount -= take;
                if (filled == cap) {                     // 꽉 참 → 트립 확정
                    trips.add(far);
                    filled = 0;
                }
            }
        }
        if (filled > 0) trips.add(far);                  // 덜 찬 마지막 트립
        return trips;
    }
}