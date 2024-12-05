# Input
N, M = map(int, input().split())
graph = [[] for _ in range(N)]
for _ in range(M):
  i, j = map(int, input().split())
  graph[i].append(j)
  graph[j].append(i)

# DFS
flag = False
visited = [0] * (N+1)

def dfs(now, depth):
  global flag
  visited[now] = True
  
  # 깊이 4 인지 확인
  if depth == 4:
    flag = True
    return
  
  # 탐색
  for n in graph[now]:
    if visited[n]:
      continue
    visited[n] = True
    dfs(n, depth+1)
    visited[n] = False

# Main
for i in range(N):
  dfs(i, 0)
  visited[i] = False
  if flag:
    break
  

# Output
if flag:
  print(1)
else:
  print(0)