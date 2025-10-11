from collections import deque

def solution(people, limit):
    
    result = 0
    queue = deque(sorted(people, reverse=True))
    
    while len(queue) > 1:
        if queue[0] + queue[-1] <= limit:
            result += 1
            queue.popleft()
            queue.pop()
        else:
            result += 1
            queue.popleft()
            
    if queue:
        result += 1
        
    return result