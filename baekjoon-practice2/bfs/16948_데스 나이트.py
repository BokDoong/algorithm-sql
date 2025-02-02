from collections import deque
import sys
input = sys.stdin.readline


# 보드
N = int(input().rstrip())
board = [[False] * N for _ in range(N)]

# 시작, 끝
startX, startY, endX, endY = map(int, input().split())
board[startX][startY] = True

# 이동 벡터
dx = [-2, -2, 0, 0, 2, 2]
dy = [-1, 1, -2, 2, -1, 1]

# 이동 큐 : (x, y, 깊이)
queue = deque([])
queue.append((startX, startY, 0))

# BFS
while queue:
  # x, y, 깊이
  x, y, depth = queue.popleft()
  
  # 도착했는지 확인
  if x == endX and y == endY:
    print(depth)
    exit()
  
  # 이동
  for i in range(6):
    # 다음 노드
    nextX, nextY = x+dx[i], y+dy[i]
    # 벗어났는지 확인
    if nextX < 0 or nextY < 0 or nextX >= N or nextY >= N:
      continue
    # 이미 방문했는지 확인
    if board[nextX][nextY]:
      continue
    # 방문
    board[nextX][nextY] = True
    queue.append((nextX, nextY, depth+1))
    
# 없음
print(-1)