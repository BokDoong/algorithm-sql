import sys
input = sys.stdin.readline

# 보드 세로, 가로
N, M = map(int, input().split())

# 보드
board = [input().rstrip() for _ in range(N)]
  
# 결과값
result = sys.maxsize

# 이동 벡터
dxs = [1, -1, 0, 0]
dys = [0, 0, -1, 1]

# 동전 첫 위치
def getStartPos():
  coinPos = []
  for i in range(N):
    for j in range(M):
      if board[i][j] == 'o':
        coinPos.append((i, j))
  return coinPos

# 범위 내에 있는지 확인
def inRange(x, y):
  return 0 <= x < N and 0 <= y < M

# 갈 수 있는지 확인
def canGo(x, y):
  if 0 <= x < N and 0 <= y < M:
    return not board[x][y] == '#'
  return True
  
# 백트래킹
def backTracking(depth, firstX, firstY, secondX, secondY):
  global result
  
  # 둘다 떨어졌는지 확인
  if not inRange(firstX, firstY) and not inRange(secondX, secondY):
    return
  # 둘 중 하나만 떨어졌는지 확인
  elif not inRange(firstX, firstY) or not inRange(secondX, secondY):
    result = min(result, depth)
    return
  
  # 10번 이상 떨어지면 리턴
  if depth == 10:
    return
  
  # 이동
  for dx, dy in zip(dxs, dys):
    # 두 동전의 다음 이동 좌표
    nextFirstX, nextFirstY, nextSecondX, nextSecondY = firstX+dx, firstY+dy, secondX+dx, secondY+dy
    
    if canGo(nextFirstX, nextFirstY) and canGo(nextSecondX, nextSecondY):
      backTracking(depth+1, nextFirstX, nextFirstY, nextSecondX, nextSecondY)
    elif canGo(nextSecondX, nextSecondY):
      backTracking(depth+1, firstX, firstY, nextSecondX, nextSecondY)
    elif canGo(nextFirstX, nextFirstY):
      backTracking(depth+1, nextFirstX, nextFirstY, secondX, secondY)

# Main
firstCoinPos, secondCoinPos = getStartPos()
backTracking(0, firstCoinPos[0], firstCoinPos[1], secondCoinPos[0], secondCoinPos[1])


# Output
if result == sys.maxsize:
  print(-1)
else:
  print(result)