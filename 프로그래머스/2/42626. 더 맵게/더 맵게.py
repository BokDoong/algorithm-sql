import copy
import heapq

def solution(scoville, K):
    # 정렬
    heapq.heapify(scoville)
    tmp = 0
    while scoville[0] < K and len(scoville)>=2:
        min1, min2 = heapq.heappop(scoville), heapq.heappop(scoville)
        heapq.heappush(scoville, min1+2*min2)
        tmp+=1
        
    
    # 최소 값이 7보다 큰지 확인
    if scoville[0] >= K:
        return tmp
    else:
        return -1