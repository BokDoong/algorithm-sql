import sys
input = sys.stdin.readline

# 탐색
def can_input(x, y, value):
  global board
  
  # 가로 탐색
  if value in board[x]:
    return False
  # 세로 탐색
  for i in range(9):
    if board[i][y] == value:
      return False
  # 같은 3x3에 있는지 탐색
  startX, startY = (x//3)*3, (y//3)*3
  for i in range(3):
    for j in range(3):
      if board[startX+i][startY+j] == value:
        return False
  # 넣을 수 있음
  return True
  
  
# 출력
def printBoard():
  global board
  
  # 스도쿠판 출력
  for i in range(9):
    for j in range(9):
      print(board[i][j], end=' ')
    print()
  
  
  
# 백트래킹
def backTracking(depth):
  global blankLength, blank
  
  # 탐색 종료
  if depth == blankLength:
    printBoard()
    exit()
    
  # 백트래킹
  for val in range(1, 10):
    x, y = blank[depth]   # 빈칸 좌표
    if can_input(x, y, val):   # 빈칸에 값을 넣을 수 있는지 검사
      board[x][y] = val
      backTracking(depth+1)
      board[x][y] = 0



# 빈칸 위치
blank = []

# 스도쿠
board = [[] for _ in range(9)]
for i in range(9):
  tmp = list(map(int, input().split()))
  for j in range(9):
    if tmp[j] == 0:
      blank.append((i,j))
    board[i].append(tmp[j])
    
# 빈칸 개수
blankLength = len(blank)

# Output
backTracking(0)