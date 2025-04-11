def solution(k, dungeons):
    # DFS
    def dfs(depth, visited, nums):
        nonlocal dungeons, answer, k
        # 탐색 끝
        if depth == len(dungeons):
            hp = k
            cnt = 0
            for i in nums:
                if dungeons[i][0] <= hp:
                    hp -= dungeons[i][1]
                    cnt += 1
                else:
                    break
            answer = max(answer, cnt)
            return
        # 탐색
        for i in range(len(dungeons)):
            if visited[i]:
                continue
            nums.append(i)
            visited[i] = True
            dfs(depth+1, visited, nums)
            visited[i] = False
            nums.pop()
    
    # Main
    answer = 0
    visited = [False]*len(dungeons)
    dfs(0, visited, [])
    return answer