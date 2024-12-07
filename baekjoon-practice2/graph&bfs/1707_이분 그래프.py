from collections import deque

# Input
K = int(input())

# 탐색
def solve(V, graph, start, visited):
  # 초기화
  group = [0] * (V+1)
  queue = deque([start])
  
  # 처음값 처리
  group[start] = 1
  visited[start] = True
  
  # 탐색
  while(queue):
    # 노드 뽑아서 그룹 확인
    now = queue.popleft()
    nowGroup = group[now]
    
    # 인접 노드 확인
    for v in graph[now]:
      # 같은 그룹인지 확인
      if nowGroup == group[v]:
        return False
      # 방문 처리 + 다른 그룹에 넣기
      if not visited[v]:
        group[v] = nowGroup * -1
        visited[v] = True
        queue.append(v)
  
  return True

# Main
for _ in range(K):
  # 그래프, 간선, 정점 입력
  V, E = map(int, input().split())
  visited = [False] * (V+1)
  graph = [[] for _ in range(V+1)]
  for __ in range(E):
    i, j = map(int,input().split())
    graph[i].append(j)
    graph[j].append(i)
  
  # BFS
  flag = True
  for v in range(1, V+1):
    if not visited[v]:
      if not solve(V, graph, v, visited):
        flag = False
        break
  
  if flag:
    print("YES")
  else:
    print("NO")