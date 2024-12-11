from collections import deque

# Input
M, N = map(int, input().split())

tomatoes = []
for _ in range(N):
  tomatoes.append(list(map(int, input().split())))
  

# Main
# 익어있는 토마토  찾기
queue = deque()
for i in range(N):
  for j in range(M):
    tomato = tomatoes[i][j]
    if tomato == 1:
      queue.append((i, j))
  
# BFS
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
while(queue):
  now = queue.popleft()
  now_status = tomatoes[now[0]][now[1]]
  
  for i in range(4):
    nextX = now[0] + dx[i]
    nextY = now[1] + dy[i]
    
    # 범위에서 벗어나는지 체크
    if nextX < 0 or nextY < 0 or nextX >= N or nextY >= M:
      continue
    
    # 비어있을 때
    next_status = tomatoes[nextX][nextY]
    if next_status != 0:
      continue
    
    # 익히고, 큐에 담기
    tomatoes[nextX][nextY] = now_status + 1
    queue.append((nextX, nextY))
    

# Output
result = 0
for i in range(N):
  for j in range(M):
    if tomatoes[i][j] == 0:
      print(-1)
      exit()
    result = max(tomatoes[i][j], result)
    
print(result-1)