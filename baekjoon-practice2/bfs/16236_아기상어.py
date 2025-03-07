import sys
from collections import deque
import heapq

def bfs(x,y):
  global res, eat, size
  dx = [1,-1,0,0]
  dy = [0,0,1,-1]
  
  # 아기상어가 먹을 수 있는 물고기가 없을 때까지 반복
  while True:
    queue = deque([[x,y,0]])  # 아기상어
    visited = [[False]*n for _ in range(n)]
    visited[x][y] = True
    heap = []
    flag = n**2
    
    # 아기상어가 갈 수 있는 모든 곳을 탐색
    while queue:
      a,b,cnt = queue.popleft()
      
      # 더이상 갈 곳없음
      if cnt > flag:
        break
      
      # 상하좌우 탐색
      for i in range(4):
        nx = a+dx[i]
        ny = b+dy[i]

        if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == False and graph[nx][ny] <= size:
          if graph[nx][ny] < size and graph[nx][ny]!=0:
            heapq.heappush(heap, (nx,ny,cnt+1))
            flag = cnt    # 아기 상어가 먹는 최소 이동시간 초기화
          
          queue.append([nx,ny,cnt+1])
          visited[nx][ny] = True
    
    # 아기상어 먹을 수 있는 물고기 있다면
    if len(heap) > 0:
      x, y, move = heapq.heappop(heap)
      res += move
      eat += 1
      graph[x][y] = 0
      
      if eat == size:
        size += 1
        eat = 0
    else:
      break
    
    
n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
size = 2 # 아기 상어의 크기
res = 0 # 최소 이동 시간
eat = 0 # 먹은 물고기 수

# 아기 상어의 위치를 찾는다.
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            graph[i][j] = 0 # 아기 상어의 위치를 0으로 초기화
            bfs(i, j)
            break
print(res)