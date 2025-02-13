import heapq

def solution(food_times, k):
    # 답
    answer = -1
    # 최소힙, (섭취시간, 순번)
    hq = []
    for i in range(len(food_times)):
        heapq.heappush(hq, (food_times[i], i+1))
    # 음식 갯수
    length = len(hq)
    # 이전 음식 섭취시간
    pre = 0
    
    # 섭취
    while hq:
        # 가장 섭취시간이 적은 음식을 한사이클 먹는데 걸리는 시간
        diff = (hq[0][0] - pre) * length
        # 다음 시간 K보다 작거나 같으면 다음 사이클
        if diff <= k:
            k -= diff
            length -= 1
            pre, _ = heapq.heappop(hq)
        # 사이클 못돌림 - 마지막 사이클이었음
        else:
            idx = k % length
            hq.sort(key = lambda x: x[1])
            answer = hq[idx][1]
            break
            
    return answer