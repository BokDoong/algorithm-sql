from collections import deque
import sys

def solution(n, wires):
    answer = sys.maxsize
    
    # BFS
    def bfs(start):
        nonlocal graph, visited
        answer = 0
        queue = deque([start])
        while queue:
            node = queue.popleft()
            for connected in graph[node]:
                if visited[connected]:
                    continue
                visited[connected] = True
                answer += 1
                queue.append(connected)
        return answer
    
    # 그래프 구성
    graph = {}
    for i in range(1, n+1):
        graph[i] = []
    for node1, node2 in wires:
        graph[node1].append(node2)
        graph[node2].append(node1)
    
    # 완탐
    for node1, node2 in wires:
        # wires에서 하나씩 끊기
        graph[node1].remove(node2)
        graph[node2].remove(node1)
        # BFS/방문기록
        visited = [False] * (n+1)
        visited[node1] = True
        visited[node2] = True
        cnt1 = bfs(node1)
        cnt2 = bfs(node2)
        # 초기화
        graph[node1].append(node2)
        graph[node2].append(node1)
        # 차이 계속 계산
        answer = min(abs(cnt1-cnt2), answer)

    return answer