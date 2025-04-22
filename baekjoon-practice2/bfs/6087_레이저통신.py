from collections import deque
import sys
input = sys.stdin.readline

# 안 벗어나는지 검사
def canMove(x, y):
  global board, W, H
  if x < 0 or y < 0 or x >= H or y >= W or (x,y) in walls:
    return False
  return True

# 끝인지 검사
def isDestination(x, y):
  global destX, destY
  return x == destX and y == destY

# 옆방향 추출
def extractReflectedVector(v):
  if v == 0 or v == 1:
    return [2, 3]
  else:
    return [0, 1]

# C 좌표, 벽
c = []
walls = set()
# W, H, 벽/도착점
W, H = map(int, input().split())
for h in range(H):
  tmp = list(input().rstrip())
  for w in range(W):
    if tmp[w] == 'C':
      c.append((h,w))
    elif tmp[w] == '*':
      walls.add((h,w))

# 시작점, 도착점
startX, startY = c[0][0], c[0][1]
destX, destY = c[1][0], c[1][1]

# 큐, 상하좌우 : 0/1/2/3
queue = deque([])
queue.append((startX, startY, 4, 0))
dx, dy = [1,-1,0,0], [0,0,-1,1]

# 보드
board = [[False]*W for _ in range(H)]
board[startX][startY] = 1
  
# BFS
answer = 0 
while queue:
  nowX, nowY, v, mirror = queue.popleft()    # 좌표, 이동방향, 거울
  # 끝인지 검사
  if isDestination(nowX, nowY):
    answer = mirror
    break
  # 레이저
  for i in range(4):
    # 다음방향, 다른 방향이면 +1
    nextX, nextY = nowX+dx[i], nowY+dy[i]
    tmpMirror = mirror
    if i != v:
      tmpMirror += 1
    # 레이저
    while True:
      if canMove(nextX, nextY):
        if not board[nextX][nextY]:
          board[nextX][nextY] = tmpMirror
          queue.append((nextX, nextY, i, tmpMirror))
        nextX, nextY = nextX+dx[i], nextY+dy[i]
      else:
        break
              
# Output
print(board[destX][destY]-1)