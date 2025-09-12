import sys
input = sys.stdin.readline

def omok(x,y):
  for i in range(4):
    cnt = 0
    
    minus = -1
    while board[x+(minus*dx[i])][y+(minus*dy[i])] == board[x][y]:
      cnt += 1
      minus -= 1
    
    plus = 1
    while board[x+(plus*dx[i])][y+(plus*dy[i])] == board[x][y]:
      cnt += 1
      plus += 1
    
    if cnt == 4:
      return True
  
  return False


N = int(input())
board = [[-1]*21 for _ in range(21)]

turns = []
dx, dy = [1, 1, 0, -1], [0, 1, 1, 1]
for _ in range(N):
  x, y = map(int, input().split())
  turns.append((x, y))
  
for n in range(1, N+1):
  x, y = turns[n-1]
  board[x][y] = n%2
  if omok(x, y):
    print(n)
    exit()
    
print(-1)
