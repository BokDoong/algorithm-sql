import sys
input = sys.stdin.readline

# N, M
N, M = map(int, input().split())
# 경로표
paths = [['-']*(N+1) for _ in range(N+1)]
# 그래프 정보
graph = [[sys.maxsize]*(N+1) for _ in range(N+1)]
for _ in range(M):
  node1, node2, cost = map(int, input().split())
  graph[node1][node2] = cost
  graph[node2][node1] = cost    # 엣지 정보 업데이트
  paths[node1][node2] = node2
  paths[node2][node1] = node1   # 경로 정보 업데이트
  
# 자신으로 가는 것은 0으로 수정
for x in range(1, N+1):
  graph[x][x] = 0
  
# 플로이드 워셜
for k in range(1,N+1):        # 거치는 경로
  for x in range(1,N+1):        # 시작
    for y in range(1,N+1):        # 끝
      if graph[x][y] > graph[x][k]+graph[k][y]:
        if x == k:
          paths[x][y] = y
        else:
          paths[x][y] = paths[x][k]
        graph[x][y] = graph[x][k]+graph[k][y]
        
# 결과
for i in range(1,N+1):
  print(*paths[i][1:])