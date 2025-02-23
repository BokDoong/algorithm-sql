import sys
input = sys.stdin.readline

# 이동
def move():
  global sharks, R, C
  for size in sharks:       # 상어
    x, y, s, d = sharks[size]
    tmp = s
    # 좌우 이동
    if d == 3 or d == 4:
      while tmp > 0:
        # 왼쪽 방향
        if d == 4:         
          left = y-1
          if left < tmp:
            tmp -= left
            y = 1
            d = 3
          else:
            y -= tmp
            tmp = 0
        # 오른쪽 방향
        else:          
          right = C - y
          if right < tmp:
            tmp -= right
            y = C
            d = 4
          else:
            y += tmp
            tmp = 0
    # 상하 이동
    elif d == 1 or d == 2:
      while tmp > 0:
        # 위 방향
        if d == 1:
          up = x-1
          if up < tmp:
            tmp -= up
            x = 1
            d = 2
          else:
            x -= tmp
            tmp = 0
        # 아래 방향
        else:
          down = R - x
          if down < tmp:
            tmp -= down
            x = R
            d = 1
          else:
            x += tmp
            tmp = 0
    # 이동한 상어
    sharks[size] = (x, y, s, d)
  
# 상어 위치 -> 보드에 넣기
def sharkToBoard():
  global board, sharks
  board = [[0]*(C+1) for _ in range(R+1)]
  removedSharks = []                # 제거할 상어 목록
  
  for size in sharks:
    x, y, s, d = sharks[size]  
    beforeShark = board[x][y]       # 이동할 위치의 상어
    if beforeShark == 0:
      board[x][y] = size            # 아무도 없으면 그냥 배치
    else:
      if beforeShark < size:
        board[x][y] = size
        removedSharks.append(beforeShark)     # 더 작으면 잡아먹기
      else:
        removedSharks.append(size)            # 이미 더 크면 잡아먹힘
    
  for shark in removedSharks:               # 잡아먹히는 애들 처리
    del sharks[shark]     

# 상어 잡기
def catchShark(t):
  global board, R, sharks
  for r in range(1,R+1):
    if board[r][t] > 0:
      caughtShark = board[r][t]
      del sharks[caughtShark]    # 상어 제거
      board[r][t] = 0
      return caughtShark
  return 0

# 격판 : R,C  //  상어의 수 : M
R, C, M = map(int, input().split())
# 격판 : 크기 정보가 있음
board = [[0]*(C+1) for _ in range(R+1)]
# 상어 정보
sharks = {}   # 크키: (속력, 방향)
for _ in range(M):
  r, c, s, d, z = map(int, input().split())
  sharks[z] = (r, c, s, d)
  board[r][c] = z
  
# 이동
result = 0
for t in range(1, C+1):
  # 물고기 잡기
  result += catchShark(t)
  # 이동
  move()
  # 상어 위치 초기화
  sharkToBoard()
  
# 로그
print(result)