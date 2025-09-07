import sys
input = sys.stdin.readline

# 갈 수 있는지체크
def canGo(x,y):
  if 1 <= x <= 19 and 1 <= y <= 19:
    return True
  return False

# DFS : 5개인지 체크
def omok(nowX, nowY, color, vector, connectedCount, gameCount):
  global board, dx, dy
  
  cnt = 1

  # 앞으로(+vector)
  x, y = nowX + dx[vector], nowY + dy[vector]
  while canGo(x, y) and board[x][y] == color:
    cnt += 1
    x += dx[vector]
    y += dy[vector]
  fx, fy = x, y  # 앞으로 진행 끝난 다음 칸

  # 뒤로(-vector)
  x, y = nowX - dx[vector], nowY - dy[vector]
  while canGo(x, y) and board[x][y] == color:
    cnt += 1
    x -= dx[vector]
    y -= dy[vector]
  bx, by = x, y  # 뒤로 진행 끝난 다음 칸

  if cnt == 5:
    end_ok = True
    if canGo(fx, fy) and board[fx][fy] == color:
      end_ok = False
    if canGo(bx, by) and board[bx][by] == color:
      end_ok = False
    if end_ok:
      print(gameCount)
      sys.exit(0)
    
# 보드 ( 흑 : 1, 백 : 0 )
board = [[-1] * 20 for _ in range(20)]
# 이동방향
dx, dy = [0, 1, 1, 1, 0, -1, -1, -1], [1, 1, 0, -1, -1, -1, 0, 1]

# 입력
N = int(input())
games = [0]
for _ in range(N):
  x, y = map(int, input().split())
  games.append((x,y))

# 9 보다 작으면 끝
if N < 9:
  print(-1)
  exit()
# 아니면 오목 ㄱㄱ
else:
  # 9 이전
  for i in range(1, 9):
    x, y = games[i]
    board[x][y] = i%2
  # 9 부터
  for i in range(9, N+1):
    x, y = games[i]
    board[x][y] = i%2
    for v in range(8):
      omok(x, y, i%2, v, 1, i)

print(-1)