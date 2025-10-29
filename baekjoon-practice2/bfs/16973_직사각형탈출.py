from collections import deque
import sys
input = sys.stdin.readline

def canGo(x, y):
  if 1 <= x <= N and 1 <= y <= M:
    return True
  return False

N, M = map(int, input().split())
board = [[-1]*M]
for _ in range(N):
  board.append([-1] + list(map(int, input().split())))
H, W, Sr, Sc, Fr, Fc = map(int, input().split())

queue = deque([(Sr, Sc, 0)])
visited = {(Sr, Sc)}

while queue:
  startX, startY, moveCount = queue.popleft()
  
  # 도달
  if startX == Fr and startY == Fc:
    print(moveCount)
    exit()

  # 위
  if canGo(startX-1, startY) and (startX-1, startY) not in visited:
    isWall = False
    for j in range(startY, startY+W):
      if board[startX-1][j] == 1:
        isWall = True
        break
    if not isWall:
      visited.add((startX-1, startY))
      queue.append((startX-1, startY, moveCount+1))
  
  # 오른쪽
  if canGo(startX, startY+W) and (startX, startY+1) not in visited:
    isWall = False
    for i in range(startX, startX+H):
      if board[i][startY+W] == 1:
        isWall = True
        break
    if not isWall:
      visited.add((startX, startY+1))
      queue.append((startX, startY+1, moveCount+1))
  
  # 아래
  if canGo(startX+H, startY) and (startX+1, startY) not in visited:
    isWall = False
    for j in range(startY, startY+W):
      if board[startX+H][j] == 1:
        isWall = True
        break
    if not isWall:
      visited.add((startX+1, startY))
      queue.append((startX+1, startY, moveCount+1))
  
  # 왼쪽
  if canGo(startX, startY-1) and (startX, startY-1) not in visited:
    isWall = False
    for i in range(startX, startX+H):
      if board[i][startY-1] == 1:
        isWall = True
        break
    if not isWall:
      visited.add((startX, startY-1))
      queue.append((startX, startY-1, moveCount+1))
    
print(-1)