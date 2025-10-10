from collections import deque

def solution(tickets):
    
    # 그래프 구성
    graph = {}
    for start, end in tickets:
        if start in graph:
            graph[start].append((end))
        else:
            graph[start] = [end]
            
    # 그래프 정렬
    for city in graph:
        graph[city].sort()
        graph[city] = deque(graph[city])
            
    # DFS
    def DFS(start, path):
        nonlocal result, tickets
        
        if len(path) == len(tickets)+1:
            result.append(path)
            return
        
        for idx, cities in enumerate(tickets):
            if cities[0] == start and not visited[idx]:
                visited[idx] = True
                DFS(cities[1], path + [cities[1]])
                visited[idx] = False
    
    result = []
    visited = [False for _ in range(len(tickets))]
    DFS('ICN', ['ICN'])
    result.sort()
    
    return result[0]