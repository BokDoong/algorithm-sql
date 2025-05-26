def solution(numbers, target):
    answer = 0
    
    def dfs(depth, maxLen, now):
        nonlocal numbers, answer, target
        # 탐색 끝
        if depth == maxLen:
            if now == target:
                answer += 1
            return
        # 탐색
        dfs(depth+1, maxLen, now+numbers[depth])
        dfs(depth+1, maxLen, now-numbers[depth])
    
    dfs(0, len(numbers), 0)
    return answer