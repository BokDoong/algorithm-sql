from collections import deque

def solution(arr):
    queue = deque([-1])
    for num in arr:
        if queue[-1] == num:
            continue
        queue.append(num)
    queue.popleft()
    return list(queue)