from collections import deque
import sys
input = sys.stdin.readline

# 범위 안인지 체크
def canMove(x, y):
  global N, M
  if 0 <= x < N and 0 <= y < M:
    return True
  return False

# 벽인지 체크
def isWall(x, y):
  global board
  if board[x][y] == '#':
    return True
  return False

# 입력
N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

# 동전 찾기
pos = []
for n in range(N):
  for m in range(M):
    if board[n][m] == 'o':
      pos.append(n)
      pos.append(m)
x1, y1, x2, y2 = pos[0], pos[1], pos[2], pos[3]

# 굴리기
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
queue = deque([(x1, y1, x2, y2, 0)])
while queue:
  nowX1, nowY1, nowX2, nowY2, rollCount = queue.popleft()
  if rollCount > 10:
    print(-1)
    exit()
  for i in range(4):
    nextX1, nextY1, nextX2, nextY2 = nowX1 + dx[i], nowY1 + dy[i], nowX2 + dx[i], nowY2 + dy[i]
    if canMove(nextX1, nextY1) and canMove(nextX2, nextY2):
      if isWall(nextX1, nextY1):
        nextX1, nextY1 = nowX1, nowY1
      if isWall(nextX2, nextY2):
        nextX2, nextY2 = nowX2, nowY2
      queue.append((nextX1, nextY1, nextX2, nextY2, rollCount+1))
    elif canMove(nextX1, nextY1):
      print(rollCount+1)
      exit()
    elif canMove(nextX2, nextY2):
      print(rollCount+1)
      exit()
