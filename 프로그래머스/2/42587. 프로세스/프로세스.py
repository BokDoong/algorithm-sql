import copy
from collections import deque

def solution(priorities, location):
    # 태스크, 남은 우선순위s
    tasks = deque([])
    for i in range(len(priorities)):
        tasks.append((i, priorities[i]))        # 인덱스, 우선순위
    ranks = deque(sorted(priorities, reverse = True))
    
    # 답
    answer = [0]*len(priorities)
    turn = 1
    # 하나씩 체크
    while tasks:
        idx, priority = tasks.popleft()
        if priority == ranks[0]:
            ranks.popleft()
            answer[idx] = turn
            turn += 1
        else:
            tasks.append((idx, priority))
    
    return answer[location]