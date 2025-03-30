import heapq

def solution(jobs):
    answer, now, completed = 0, 0, 0
    start = -1
    heap = []
    
    while completed < len(jobs):
        # 작업물 넣기
        for j in jobs:
            if start < j[0] <= now:
                heapq.heappush(heap, (j[1], j[0]))
        # 작업
        if heap:
            duration, requestTime = heapq.heappop(heap)
            start = now
            now += duration
            answer += (now - requestTime)
            completed += 1
        else:
            now += 1
    
    return int(answer/len(jobs))