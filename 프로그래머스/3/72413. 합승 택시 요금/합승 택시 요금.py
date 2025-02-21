import heapq
import sys
input = sys.stdin.readline

# n:노드, s:시작노드, a/b:출발/도착노드, fares:그래프
def solution(n, s, a, b, fares):
    # 그래프
    graph = [[sys.maxsize]*(n+1) for _ in range(n+1)]
    for x in range(1,n+1):
        graph[x][x] = 0
        
    # 간선
    for node1, node2, cost in fares:
        graph[node1][node2] = cost
        graph[node2][node1] = cost
    
    # 플로이드 워셜
    for k in range(1,n+1):              # 중간
        for x in range(1,n+1):          # 시작
            for y in range(1, n+1):     # 끝
                graph[x][y] = min(graph[x][y], graph[x][k]+graph[k][y])
                
    # graph[start][end] : start~end까지 최소거리, sys.maxsize는 아예 연결이 안돼있음
    # s : 시작, a/b : a와b의 목표지점
    answer = sys.maxsize
    for k in range(1, n+1):
        answer = min(answer, graph[s][k]+graph[k][a]+graph[k][b])
    
    # 로그
    # for i in range(1, n+1):
    #     print(graph[i][1:n+1])
        
    return answer