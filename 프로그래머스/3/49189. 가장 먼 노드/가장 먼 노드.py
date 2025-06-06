from collections import deque

def solution(n, edge):
    # 그래프
    graph = [[] for _ in range(n+1)]
    for node1, node2 in edge:
        graph[node1].append(node2)
        graph[node2].append(node1)
    
    # 방문 처리
    visited = [False]*(n+1)
    visited[1] = True
    # 노드별 거리
    dist = [0]*(n+1)
    
    # BFS
    queue = deque([(1,0)])
    while queue:
        node, depth = queue.popleft()
        for nearNode in graph[node]:
            # 이미 방문 했다면 x
            if visited[nearNode]:
                continue
            # 탐색
            dist[depth] += 1
            visited[nearNode] = True
            queue.append((nearNode, depth+1))
    
    for d in dist[::-1]:
        if d == 0:
            continue
        else:
            return d
    return 0