from collections import deque
import sys
input = sys.stdin.readline

def isWall(x, y):
  global board
  if board[x][y] == '#':
    return True
  return False

def canMove(x, y):
  if 0 <= x < N and 0 <= y < M:
    return True
  return False

N, M = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(input().rstrip()))
  
coins = []
for n in range(N):
  for m in range(M):
    if board[n][m] == 'o':
      coins.append(n)
      coins.append(m)
x1, y1, x2, y2 = coins[0], coins[1], coins[2], coins[3]

visited = [[[[False]*M for _ in range(N)] for _ in range(M)] for _ in range(N)]
visited[x1][y1][x2][y2] = True

queue = deque([(x1, y1, x2, y2, 0)])
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
while queue:
  nowX1, nowY1, nowX2, nowY2, rollCount = queue.popleft()
  
  if rollCount >= 10:
    print(-1)
    exit()
  
  for i in range(4):
    nextX1, nextY1, nextX2, nextY2 = nowX1 + dx[i], nowY1 + dy[i], nowX2 + dx[i], nowY2 + dy[i]
    if canMove(nextX1, nextY1) and canMove(nextX2, nextY2):
      if isWall(nextX1, nextY1):
        nextX1, nextY1 = nowX1, nowY1
      if isWall(nextX2, nextY2):
        nextX2, nextY2 = nowX2, nowY2
      if not visited[nextX1][nextY1][nextX2][nextY2]:
        visited[nextX1][nextY1][nextX2][nextY2] = True
        queue.append((nextX1, nextY1, nextX2, nextY2, rollCount+1))
    elif canMove(nextX1, nextY1):
      print(rollCount+1)
      exit()
    elif canMove(nextX2, nextY2):
      print(rollCount+1)
      exit()
      
print(-1)
