import sys
input = sys.stdin.readline

# 파란색으로 밀어낼 때 멈추는 열(y) 찾기
def moveToBlue(x, y):
  global board
  for i in range(4, 10):
    if board[x][i] == 1:
      return i-1
  return 9

# 초록색으로 밀어낼 때 멈추는 행(x) 찾기
def moveToGreen(x, y):
  global board
  for i in range(4, 10):
    if board[i][y] == 1:
      return i-1
  return 9

# 초록색 다 1인 행 체크 및 점수 획득
def gainGreenScore():
  global board, score
  for x in range(4, 10):
    fillCount = 0
    for y in range(4):    # 다 차있는지 체크
      if board[x][y] == 1:
        fillCount += 1
    if fillCount == 4:    # 다 차있으면 밀어내기
      score += 1
      for i in range(x, 4, -1):
        for j in range(4):    # 첫 열 0으로
          board[i][j] = board[i-1][j]
      board[4] = [0]*10
      
# 초록색 연한 보드 -> 1인 열의 개수 세기 -> 개수 만큼 밀어내기
def checkWhiteGreen():
  global board
  cnt = 0
  for x in range(4,6):
    for y in range(4):
      if board[x][y] == 1:
        cnt += 1
        break
  for _ in range(cnt):
    for x in range(9, 4, -1):
      for y in range(4):
        board[x][y] = board[x-1][y]
    for i in range(4):    # 첫 행 0으로
        board[4][i] = 0

# 파란색 다 1인 열 체크 및 점수 획득
def gainBlueScore():
  global board, score
  for y in range(4, 10):
    fillCount = 0
    for x in range(4):    # 다 차있는지 체크
      if board[x][y] == 1:
        fillCount += 1
    if fillCount == 4:    # 다 차있으면 밀어내기
      score += 1
      for i in range(y, 4, -1):
        for j in range(4):
          board[j][i] = board[j][i-1]
      for i in range(4):    # 첫 행 0으로
        board[i][4] = 0

# 파란색 연한 보드 -> 1인 행의 개수 세기 -> 개수 만큼 밀어내기
def checkWhiteBlue():
  global board
  cnt = 0
  for y in range(4,6):
    for x in range(4):
      if board[x][y] == 1:
        cnt += 1
        break
  for _ in range(cnt):
    for y in range(9, 4, -1):
      for x in range(4):
        board[x][y] = board[x][y-1]
    for i in range(4):    # 첫 행 0으로
        board[i][4] = 0
  

# 입력
N = int(input())
board = [[0]*10 for _ in range(10)]
score = 0

for _ in range(N):
  t, x, y = map(int, input().split())
  
  # 파란색, 초록색으로 밀어내기
  if t == 1:
    blueY = moveToBlue(x, y)
    greenX = moveToGreen(x,y)
    board[x][blueY] = 1
    board[greenX][y] = 1
  elif t == 2:
    blueY = moveToBlue(x, y+1)
    greenX = min(moveToGreen(x, y), moveToGreen(x, y+1))
    board[x][blueY-1], board[x][blueY] = 1, 1
    board[greenX][y], board[greenX][y+1] = 1, 1
  else:
    blueY = min(moveToBlue(x,y), moveToBlue(x+1, y))
    greenX = moveToGreen(x+1, y)
    board[x][blueY], board[x+1][blueY] = 1, 1
    board[greenX-1][y], board[greenX][y] = 1, 1
  
  # 파란색, 초록색에서 다 차있는 경우 체크해서 밀어내고, 점수 +1
  gainBlueScore()
  gainGreenScore()
  
  # 파란색, 초록색에서 연한곳 있는 경우 밀어내기
  checkWhiteGreen()
  checkWhiteBlue()
  
# 결과
cnt = 0
for x in range(10):
  for y in range(10):
    if board[x][y] == 1:
      cnt += 1
print(score)
print(cnt)