def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = []
    
    for i in range(n):
        while stack and prices[stack[-1]] > prices[i]:
            tmp = stack.pop(-1)
            answer[tmp] = i - tmp
        stack.append(i)
    
    while stack:
        tmp = stack.pop(-1)
        answer[tmp] = n-1-tmp

    return answer