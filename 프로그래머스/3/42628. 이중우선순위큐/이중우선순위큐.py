import heapq

def solution(operations):
    minHeap, maxHeap = [], []
    
    for op in operations:
        com, num = op.split(" ")
        if com == 'I':
            heapq.heappush(minHeap, int(num))
            heapq.heappush(maxHeap, -1*int(num))
        else:
            if len(minHeap) > 0:
                if num == '1':
                    maxNum = heapq.heappop(maxHeap)
                    minHeap.remove(maxNum*-1)
                else:
                    minNum = heapq.heappop(minHeap)
                    maxHeap.remove(minNum*-1)
    
    if len(minHeap) == 0:
        return [0,0]
    else:
        return [max(minHeap), min(minHeap)]