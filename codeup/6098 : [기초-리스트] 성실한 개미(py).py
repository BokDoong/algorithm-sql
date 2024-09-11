def move(currentX, currentY):
  if board[currentX][currentY] == 0:
    board[currentX][currentY] = 9
  elif board[currentX][currentY] == 2:
    board[currentX][currentY] = 9
    return

  if (currentX == 8 and currentY == 8) or (board[currentX+1][currentY] == 1 and board[currentX][currentY+1] == 1):
    return
  
  if board[currentX][currentY+1] != 1:
    move(currentX, currentY+1)
  elif board[currentX+1][currentY] != 1:
    move(currentX+1, currentY)
  
# main
board = [[0 for _ in range(10)] for __ in range(10)]
for i in range(10):
  board[i] = list(map(int, input().split()))

move(1, 1)
for i in range(10):
  for j in range(10):
    print(board[i][j], end=' ')
  print()