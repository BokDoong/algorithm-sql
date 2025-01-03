import sys
input = sys.stdin.readline

# Input
N = int(input())
board = [[0] * 101 for _ in range(101)]


# Main
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

for _ in range(N):
  y, x, d, g = map(int, input().split())
  
  # 시작 좌표
  board[x][y] = 1
 
  # 0 세대
  x = x + dx[d]
  y = y + dy[d]
  board[x][y] = 1
  
  # 1 세대 ~
  trace = [d]   # 이전 이동기록
  for _ in range(1, g+1):
    move = []   # 현재 세대 이동할 방향
    
    # 이전에꺼 +1, 뒤집기
    for i in range(len(trace)-1, -1, -1):
      move.append((trace[i]+1)%4)
      
    # 회전
    for i in move:
      x = x + dx[i]
      y = y + dy[i]
      board[x][y] = 1
      
    # 이전꺼에 추가
    trace.extend(move)
    

# 사각형 찾기
result = 0
for i in range(100):
  for j in range(100):
    if board[i][j] == 1 and board[i][j+1] == 1 and board[i+1][j] == 1 and board[i+1][j+1] == 1:
      result += 1
      

# Output
print(result)