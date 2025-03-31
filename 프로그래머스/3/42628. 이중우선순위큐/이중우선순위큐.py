import heapq

def solution(operations):
    maxHeap, minHeap = [], []
    for op in operations:
        com, num = op.split(' ')
        # 삽입
        if com == 'I':
            heapq.heappush(minHeap, int(num))
            heapq.heappush(maxHeap, -1*int(num))
        # 삭제
        else:
            if maxHeap:
                if num == '1':
                    maxNum = -1*heapq.heappop(maxHeap)
                    minHeap.remove(maxNum)
                else:
                    minNum = heapq.heappop(minHeap)
                    maxHeap.remove(-1*minNum)
                
    # 결과
    if minHeap:
        return [max(minHeap), min(minHeap)]
    else:
        return [0, 0]