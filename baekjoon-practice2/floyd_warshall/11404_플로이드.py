import sys
input = sys.stdin.readline

# N, M
N = int(input().rstrip())
M = int(input().rstrip())

# 그래프
graph = [[sys.maxsize]*(N+1) for _ in range(N+1)]
for x in range(1, N+1):
    graph[x][x] = 0

# 노선 정보
for _ in range(M):
  start, dest, cost = map(int, input().split())
  graph[start][dest] = min(graph[start][dest], cost)

# 플로이드 워셜 - 하나씩 돌면서 간선 확인
for k in range(1, N+1):
  for x in range(1, N+1):
    for y in range(1, N+1):
      graph[x][y] = min(graph[x][y], graph[x][k]+graph[k][y])
      
# 출력
for x in range(1, N+1):
  for y in range(1, N+1):
    if graph[x][y] == sys.maxsize:
      graph[x][y] = 0
    print(graph[x][y], end=' ')
  print()