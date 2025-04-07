from collections import deque
import sys
input = sys.stdin.readline

# 익을 수 있는지 체크
def check(h,x,y):
  global N, M, H, tomatoes
  if 0 <= h < H and 0 <= x < N and 0 <= y < M and tomatoes[h][x][y] == 0:
    return True
  return False
    
# 큐, 걸린 시간
queue = deque([])
duration = 0

# M, N, H
M, N, H = map(int, input().split())
# 토마토
tomatoes = [[[0]*M for _ in range(N)] for _ in range(H)]
for h in range(H):
  for x in range(N):
    tomato = list(map(int, input().split()))
    for y in range(len(tomato)):
      if tomato[y] == 1:
        queue.append((h,x,y,0))
    tomatoes[h][x] = tomato
  
# BFS
dx, dy = [1,-1,0,0], [0,0,1,-1]
dh = [1,-1]
while queue:
  h, x, y, now = queue.popleft()
  duration = max(now, duration)
  # 같은 층
  for i in range(4):
    nextX, nextY = x+dx[i], y+dy[i]
    if check(h, nextX, nextY):
      tomatoes[h][nextX][nextY] = 1
      queue.append((h,nextX,nextY,now+1))
  # 위/아래 층
  for i in range(2):
    nextH = h+dh[i]
    if check(nextH, x, y):
      tomatoes[nextH][x][y] = 1
      queue.append((nextH,x,y,now+1))
      
# 결과
flag = True
for h in range(H):
  for x in range(N):
    for y in range(M):
      if tomatoes[h][x][y] == 0:
        flag = False
        break
      
if flag:
  print(duration)
else:
  print(-1)