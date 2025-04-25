from collections import deque

def solution(people, limit):
    answer = 0
    
    # 정렬
    people.sort()
    queue = deque(people)
    
    # 구조
    while queue:
        # 가장 무거운 사람 빼기
        heaviest = queue.pop()
        # 가장 가벼운 사람과 함께 빠질 수 있다면 빠지기
        if len(queue) > 0 and (heaviest + queue[0]) <= limit:
            queue.popleft()
        answer += 1
        
    return answer