# 입력
result = 0
n, m = map(int, input().split())
board = []
for i in range(n):
  board.append(list(map(int, input().split())))

# 2x2
for i in range(0, n-1):
  for j in range(0, m-1):
    result = max(result, board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1])

# 3x2
for i in range(0, n-1):
  for j in range(0, m-2):
    up = board[i][j] + board[i][j+1] + board[i][j+2]
    down = board[i+1][j] + board[i+1][j+1] + board[i+1][j+2]
    for k in range(0, 3):
      result = max(result, up + board[i+1][j+k])
      result = max(result, down + board[i][j+k])
    result = max(result, board[i][j+1]+board[i][j+2]+board[i+1][j]+board[i+1][j+1], board[i][j]+board[i][j+1]+board[i+1][j+1]+board[i+1][j+2])
    
# 2x3
for i in range(0, n-2):
  for j in range(0, m-1):
    left = board[i][j] + board[i+1][j] + board[i+2][j]
    right = board[i][j+1] + board[i+1][j+1] + board[i+2][j+1]
    for k in range(0, 3):
      result = max(result, left + board[i+k][j+1])
      result = max(result, right + board[i+k][j])
    result = max(result, board[i][j]+board[i+1][j]+board[i+1][j+1]+board[i+2][j+1], board[i][j+1]+board[i+1][j]+board[i+1][j+1]+board[i+2][j])
    
# 1x4
for i in range(0, n-3):
  for j in range(0, m):
    result = max(result, board[i][j]+board[i+1][j]+board[i+2][j]+board[i+3][j])

# 4x1
for i in range(0, n):
  for j in range(0, m-3):
    result = max(result, board[i][j]+board[i][j+1]+board[i][j+2]+board[i][j+3])
    
# 결과
print(result)