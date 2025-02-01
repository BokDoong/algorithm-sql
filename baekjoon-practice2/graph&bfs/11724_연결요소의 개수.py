from collections import deque

# Input
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
  i, j = map(int, input().split())
  graph[i].append(j)
  graph[j].append(i)
  
# Main
# 1. DFS
visited = [False] * (N+1)
def dfs(now):
  
  # 탐색
  for v in graph[now]:
    if not visited[v]:
      visited[v] = True
      dfs(v)
      
# 2. 시작점 하나씩 DFS
cnt = 0
for i in range(1, N+1):
  if not visited[i]:
    cnt += 1
    visited[i] = True
    dfs(i)

# Output
print(cnt)
