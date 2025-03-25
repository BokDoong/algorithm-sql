from collections import deque

def solution(s):
    # 스택
    stack = deque([])
    for ss in s:
        if ss == '(':
            stack.append(ss)
        else:
            if len(stack) == 0:
                return False
            else:
                stack.pop()
    
    # 결과
    if len(stack) > 0:
        return False
    else:
        return True