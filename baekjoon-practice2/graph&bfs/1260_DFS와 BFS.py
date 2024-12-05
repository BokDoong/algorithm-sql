from collections import deque

# Input
N, M, V = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
  v1, v2 = map(int, input().split())
  graph[v1].append(v2)
  graph[v2].append(v1)
  graph[v1].sort()
  graph[v2].sort()

# DFS
visited1 = [0] * (N+1)
vertexes1 = []
def dfs(now, depth):
  global N, visited1, vertexes1

  # 탐색
  for v in graph[now]:
    if visited1[v]:
      continue
    
    vertexes1.append(v)
    visited1[v] = True
    dfs(v, depth+1)


# BFS
visited2 = [0] * (N+1)
vertexes2 = []
def bfs(now, depth):
  global visited2, vertexes2, V
  
  queue = deque([V])
  visited2[V] = True
  while queue:
    # 방문
    v = queue.popleft()
    vertexes2.append(v)
    
    # 큐에 넣기
    for i in graph[v]:
      if not visited2[i]:
        queue.append(i)
        visited2[i] = True


# Main
visited1[V] = True
vertexes1.append(V)
dfs(V, 1)
for v in vertexes1:
  print(v, end = ' ')

print()
bfs(V, 1)
for v in vertexes2:
  print(v, end = ' ')