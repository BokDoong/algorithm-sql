import sys
input = sys.stdin.readline

# Calculate
# 1번
def rotate1():
  global board
  N = len(board)
  M = len(board[0])
  result = [[0] * M for _ in range(N)]

  for i in range(N):
    for j in range(M):
      result[i][j] = board[N-1-i][j]
    
  return result

# 2번
def rotate2():
  global board
  N = len(board)
  M = len(board[0])
  result = [[0] * M for _ in range(N)]
  
  for i in range(N):
    for j in range(M):
      result[i][j] = board[i][M-1-j]
      
  return result

# 3번
def rotate3():
  global board
  N = len(board)
  M = len(board[0])
  result = [[0] * N for _ in range(M)]
  
  for i in range(M):
    for j in range(N):
      result[i][j] = board[N-j-1][i]
  
  return result

# 4번
def rotate4():
  global board
  N = len(board)
  M = len(board[0])
  result = [[0] * N for _ in range(M)]
  
  for i in range(M):
    for j in range(N):
      result[i][j] = board[j][M-1-i]
      
  return result

# 5번
def rotate5():
  global board
  N = len(board)
  M = len(board[0])
  result = [[0] * M for _ in range(N)]
  
  # A구역
  for i in range(N//2):
    for j in range(M//2):
      result[i][j] = board[i+N//2][j]
  # B구역
  for i in range(N//2):
    for j in range(M//2, M):
      result[i][j] = board[i][j-M//2]
  # C구역
  for i in range(N//2, N):
    for j in range(M//2):
      result[i][j] = board[i][j+M//2]
  # D구역
  for i in range(N//2, N):
    for j in range(M//2, M):
      result[i][j] = board[i-N//2][j]
  
  return result

# 6번
def rotate6():
  global board
  N = len(board)
  M = len(board[0])
  result = [[0] * M for _ in range(N)]
  
  # A구역
  for i in range(N//2):
    for j in range(M//2):
      result[i][j] = board[i][j+M//2]
  # B구역
  for i in range(N//2):
    for j in range(M//2, M):
      result[i][j] = board[i+N//2][j]
  # C구역
  for i in range(N//2, N):
    for j in range(M//2):
      result[i][j] = board[i-N//2][j]
  # D구역
  for i in range(N//2, N):
    for j in range(M//2, M):
      result[i][j] = board[i][j-M//2]
  
  return result


# Input
N, M, R = map(int, input().split())
board = [[] for _ in range(N)]
for i in range(N):
  board[i] = list(map(int, input().split()))
  
  
# Output
commands = list(map(int, input().split()))
for com in commands:
  if com == 1:
    board = rotate1()
  elif com == 2:
    board = rotate2()
  elif com == 3:
    board = rotate3()
  elif com == 4:
    board = rotate4()
  elif com == 5:
    board = rotate5()
  else:
    board = rotate6()
  
N = len(board)
M = len(board[0])
for i in range(N):
  for j in range(M):
    print(board[i][j], end=' ')
  print()