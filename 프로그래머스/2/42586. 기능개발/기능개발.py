from collections import deque
import math

def solution(progresses, speeds):
    answer = []
    
    # 각 작업마다 남은 일수 계산
    days = [math.ceil((100 - progresses[i]) / speeds[i]) for i in range(len(progresses))]
    
    # 순서대로 작업을 처리
    now = days[0]
    cnt = 1
    for i in range(1, len(days)):
        if days[i] <= now:
            cnt += 1
        else:
            answer.append(cnt)
            now = days[i]
            cnt = 1
    answer.append(cnt)  # 마지막 배포

    return answer