from collections import deque
import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())

# 디버그
def debug():  
  print("==============")
  print("result : ", result)
  print("(x,  y) : ", x, y)
  print("v : ", v)
  print("bottom : ", bottom)
  print("==============")

# 이동하며 같은 숫자가 몇 칸있는지 확인
def calculateScore(x, y, target):
  result, queue = 1, deque([(x, y)])
  
  visited = set()
  visited.add((x,y))
  
  while queue:
    nowX, nowY = queue.popleft()
    for i in range(4):
      nextX, nextY = nowX + dx[i], nowY + dy[i]
      if canGo(nextX, nextY) and (nextX, nextY) not in visited and board[nextX][nextY] == target:
        result += 1
        visited.add((nextX, nextY))
        queue.append((nextX, nextY))
        
  return result*target

# 이동할 수 있는지 확인
def canGo(x, y):
  if 0 <= x < N and 0 <= y < M:
    return True
  return False

# (반)시계 방향 회전
def rotate(isClock, v):
  if isClock:   # 시계 방향
    if v == 0:
      return 2
    elif v == 1:
      return 3
    elif v == 2:
      return 1
    else:
      return 0
  else:         # 반시계 방향
    if v == 0:
      return 3
    elif v == 1:
      return 2
    elif v == 2:
      return 0
    else:
      return 1
  
# 반대 방향 전환
def rotateOpposite(v):
  if v == 0:
    return 1
  elif v == 1:
    return 0
  elif v == 2:
    return 3
  else:
    return 2  

# [동 - 서 - 남 - 북]으로 움직였을 때 가장 밑에 오는 숫자
diceMoves = {}
diceMoves[1] = [3, 4, 2, 5]
diceMoves[2] = [3, 4, 6, 1]
diceMoves[3] = [1, 6, 5, 2]
diceMoves[4] = [6, 1, 5, 2]
diceMoves[5] = [3, 4, 1, 6]
diceMoves[6] = [3, 4, 5, 2]

# 보드, 이동방향
dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]
board = []
for _ in range(N):
  board.append(list(map(int, input().split())))

# 주사위
dice = [1, 6, 2, 5, 4, 3]

def roll(dir):
  global dice
  u, d, n, s, w, e = dice
  if dir == 0:      # East
    dice = [w, e, n, s, d, u]   # U<-W, D<-E, E<-U, W<-D
  elif dir == 1:    # West
    dice = [e, w, n, s, u, d]   # U<-E, D<-W, W<-U, E<-D
  elif dir == 2:    # South
    dice = [n, s, d, u, w, e]   # U<-N, D<-S, N<-D, S<-U
  else:             # North
    dice = [s, n, u, d, w, e]   # U<-S, D<-N, S<-D, N<-U  

# 이동
x, y, v = 0, 0, 0
result = 0

for _ in range(K):
  
  # 1) 이동
  nextX, nextY = x + dx[v], y + dy[v]
  if not canGo(nextX, nextY):
    v = rotateOpposite(v)
    nextX, nextY = x + dx[v], y + dy[v]
  x, y = nextX, nextY
  
  # 2) 주사위 굴리기 → 밑면이 자동으로 갱신됨
  roll(v)
  bottom = dice[1]
    
  # 3) 점수 획득
  target = board[x][y]
  result += calculateScore(x, y, target)
  
  # 4) 다음 이동방향 결정
  if bottom > target:
    v = rotate(True, v)
  elif bottom < target:
    v = rotate(False, v)
  
print(result)