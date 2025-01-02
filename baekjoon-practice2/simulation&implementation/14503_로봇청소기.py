from collections import deque
import sys
input = sys.stdin.readline  
  
# Methods
# 벗어나지 않는지 확인
def in_board(x, y):
  if 0 <= x < N and 0 <= y < M:
    return True
  return False

# 현재 칸 청소
cleaned_rooms = []
def clean():
  global cleaned_rooms, r, c, result
  
  if (r,c) not in cleaned_rooms:
    result += 1
    cleaned_rooms.append((r, c))
  
# 주변 4칸 중 청소 안된 빈칸 있는지 확인
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
def exist_uncleaned_rooms():
  global board, cleaned_rooms, r, c
  
  for i in range(4):
    nextX = r + dx[i]
    nextY = c + dy[i]
    
    # 안벗어나는지 확인
    if not in_board(nextX, nextY):
      continue
    
    # 방이고 청소 안되어 있는지 확인
    if board[nextX][nextY] == 0 and (nextX, nextY) not in cleaned_rooms:
      return True
  
  return False

# 이동
def move(dir):
   # (r, c) : 현재 위치, d : 바라보는 방향(0 - 북, 1 - 동, 2 - 남, 3 - 서)
  global r, c, d, dx, dy
  
  # 전진
  if dir == 1:
    return r+dx[d], c+dy[d]
  # 후진
  elif dir == -1:
    if d == 0:
      return r+1, c
    elif d == 1:
      return r, c-1
    elif d == 2:
      return r-1, c
    elif d == 3:
      return r, c+1
  
# 반시계 방향 회전
def rotate():
  global d
  
  if d == 0:
    d = 3
  else:
    d -= 1
    

# Input
# N : 세로, M : 가로
N, M = map(int, input().split())
# (r, c) : 현재 위치, d : 바라보는 방향(0 - 북, 1 - 동, 2 - 남, 3 - 서)
r, c, d = map(int, input().split())

# 방
board = []
for _ in range(N):
  board.append(list(map(int, input().split())))


# Main
result = 0
while True:
  # 1. 청소
  clean()
  
  # 2. 주변 4칸에 청소되지 않은 방이 없는 경우
  if not exist_uncleaned_rooms():
    # 후진 좌표
    nextX, nextY = move(-1)
    # 벽이거나, 벗어나는지 확인
    if not in_board(nextX, nextY) or board[nextX][nextY] == 1:
      break
    # 후진
    r = nextX
    c = nextY
  # 3. 청소되지 않은 빈칸이 있는 경우
  else:
    while True:
      # 회전
      rotate()
      # 전진 좌표
      nextX, nextY = move(1)
      if in_board(nextX, nextY) and board[nextX][nextY] == 0 and (nextX, nextY) not in cleaned_rooms:
        r = nextX
        c = nextY
        break
      
      
# Output
print(result)