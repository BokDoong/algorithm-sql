from collections import deque
import math

def solution(progresses, speeds):
    # 정보 : (태스크 인덱스, 날짜)
    info = deque([])
    for i in range(len(progresses)):
        info.append((progresses[i], speeds[i]))
    
    # 작업
    answer = []
    while info:
        # 맨 앞에 있는애 얼마나 걸리는지 계산
        progress, speed = info.popleft()
        days = math.ceil((100-progress)/speed)
        
        # 전체 카운팅
        tmp = deque([])
        while info:
            p, s = info.popleft()
            tmp.append((p+s*days, s))
        info = tmp
        
        # popleft -> 100 넘으면 빼기
        tmp = 1
        while info:
            progress, speed = info[0]
            if progress >= 100:
                info.popleft()
                tmp += 1
            else:
                break
        answer.append(tmp)
    return answer