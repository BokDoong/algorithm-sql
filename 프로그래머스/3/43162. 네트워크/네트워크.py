from collections import deque

def solution(n, computers):
    answer = 0
    visited = [False]*n
    
    # BFS
    def bfs(start):
        nonlocal computers, n, visited
        queue = deque([start])
        # 연결된 노드 탐색
        while queue:
            node = queue.popleft()
            for i in range(n):
                if computers[node][i] == 1:
                    if not visited[i]:      # 자신 노드 x, 방문 x
                        queue.append(i)
                        visited[i] = True
                        
    # 탐색
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            answer += 1
            bfs(i)
    
    return answer