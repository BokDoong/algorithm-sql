from collections import deque
import sys
input = sys.stdin.readline


T = int(input())
result = []

for _ in range(T):
  
  # N : 건물 개수, K : 건설 순서 개수
  N, K = map(int, input().split())
  
  # 각 빌딩 건설 시간
  timeToConstructBuildings = [0]
  timeToConstructBuildings.extend(list(map(int, input().split())))
  
  # 위상 정보
  indegree = [0] * (N+1)
  
  # 그래프
  graph = [[] for _ in range(N+1)]
  DP = [0] * (N+1)
  for _ in range(K):
    start, end = map(int, input().split())
    graph[start].append(end)
    indegree[end] += 1
    
  # 큐
  queue = deque()
  for i in range(1, N+1):
    if indegree[i] == 0:
      queue.append(i)
      DP[i] = timeToConstructBuildings[i]
      
  # 위상 정렬
  while queue:
    node = queue.popleft()
    for i in graph[node]:
      indegree[i] -= 1
      DP[i] = max(DP[node] + timeToConstructBuildings[i], DP[i])
      if indegree[i] == 0:
        queue.append(i)
        
  # 결과
  target = int(input())
  result.append(DP[target])
    

for r in result:
  print(r)