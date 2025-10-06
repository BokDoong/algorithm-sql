from collections import deque
import sys
input = sys.stdin.readline

def inSameArea(now, target, disabled):
  if disabled == False:
    return now == target
  else:
    if now == 'R' or now == 'G':
      return target == 'R' or target == 'G'
    elif now == 'B':
      return target == 'B'

def canGo(x,y):
  global N
  if 0 <= x < N and 0 <= y < N:
    return True
  return False

N = int(input())
board = []
for _ in range(N):
  board.append(list(input().rstrip()))
  
dx, dy = [1,-1,0,0],[0,0,1,-1]

notDisabled = 0
visited = [[False for _ in range(N)] for __ in range(N)]
for x in range(N):
  for y in range(N):
    if not visited[x][y]:
      visited[x][y] = True
      queue = deque([(x,y)])
      while queue:
        nowX, nowY = queue.popleft()
        now = board[nowX][nowY]
        for i in range(4):
          nextX, nextY = nowX+dx[i], nowY+dy[i]
          if canGo(nextX, nextY) and not visited[nextX][nextY] and inSameArea(now, board[nextX][nextY], False):
            visited[nextX][nextY] = True
            queue.append((nextX,nextY))
      notDisabled += 1
            
disabled = 0
visited = [[False for _ in range(N)] for __ in range(N)]
for x in range(N):
  for y in range(N):
    if not visited[x][y]:
      visited[x][y] = True
      queue = deque([(x,y)])
      while queue:
        nowX, nowY = queue.popleft()
        now = board[nowX][nowY]
        for i in range(4):
          nextX, nextY = nowX+dx[i], nowY+dy[i]
          if canGo(nextX, nextY) and not visited[nextX][nextY] and inSameArea(now, board[nextX][nextY], True):
            visited[nextX][nextY] = True
            queue.append((nextX,nextY))
      disabled += 1
    
print(notDisabled, disabled)