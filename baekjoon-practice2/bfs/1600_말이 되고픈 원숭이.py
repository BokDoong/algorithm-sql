from collections import deque
import sys
input = sys.stdin.readline

# 이동할 수 있는지 체크
def canMove(x, y):
  global board, H, W
  if 0 <= x < H and 0 <= y < W:
    return True
  return False

# K, W, H
K = int(input())
W, H = map(int, input().split())

# 보드, -1로 장애물 변경
board = []
for _ in range(H):
  board.append(list(map(int, input().split())))
for h in range(H):
  for w in range(W):
    if board[h][w] == 1:
      board[h][w] = -1    

# K번 말처럼 움직인 정보를 포함하는 보드
totalBoard = []
for _ in range(K+1):
    totalBoard.append([row[:] for row in board])
  
# 이동 벡터
horseMove = [(1,2), (2,1), (2,-1), (1,-2), (-1,-2), (-2,-1), (-2,1), (-1,2)]
monkeyMove = [(1,0), (0,1), (0,-1), (-1,0)]

# BFS
queue, result = deque([(0,0,K)]), -1
while queue:
  nowX, nowY, k = queue.popleft()
  # 끝났는지 체크
  if nowX == H-1 and nowY == W-1:
    result = totalBoard[k][nowX][nowY]
    break
  # 말처럼 이동
  if k:
    for i in range(8):
      nextX, nextY = nowX + horseMove[i][0], nowY + horseMove[i][1]
      if canMove(nextX, nextY) and totalBoard[k-1][nextX][nextY] == 0:
        totalBoard[k-1][nextX][nextY] = totalBoard[k][nowX][nowY] + 1
        queue.append((nextX, nextY, k-1))
  # 원숭이 이동
  for i in range(4):
    nextX, nextY = nowX+monkeyMove[i][0], nowY+monkeyMove[i][1]
    if canMove(nextX, nextY) and totalBoard[k][nextX][nextY] == 0:
      totalBoard[k][nextX][nextY] = totalBoard[k][nowX][nowY] + 1
      queue.append((nextX,nextY,k))
  
print(result)