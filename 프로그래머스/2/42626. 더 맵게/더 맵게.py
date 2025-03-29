import copy
import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    mixCount = 0
    
    while len(scoville) >= 2 and scoville[0] < K:
        min1, min2 = heapq.heappop(scoville), heapq.heappop(scoville)
        heapq.heappush(scoville, min1+min2*2)
        mixCount += 1
    
    if scoville[0] >= K:
        return mixCount
    else:
        return -1