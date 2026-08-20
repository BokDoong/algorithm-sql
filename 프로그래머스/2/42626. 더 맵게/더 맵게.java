import java.util.*;

class Solution {
  public int solution(int[] scoville, int K) {
    // 배열 to 최소힙
    Queue<Integer> heap = new PriorityQueue<>();
    for (int s : scoville) heap.add(s);

    // 힙에서 2개 빼서 -> a + b*2 계산 -> K보다 크면 끝, K보다 작으면 answer+1 & 계산한 것 힙에 넣기
    int answer = 0;
    while (heap.peek() < K) {
      if (heap.size() < 2) return -1;
      heap.add(heap.poll() + 2 * heap.poll());
      answer++;
    }

    return answer;
  }
}