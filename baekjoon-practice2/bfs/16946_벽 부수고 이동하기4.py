from collections import deque
import copy
import sys
input = sys.stdin.readline

# 마스킹 영역 탐색
def findMaskedArea(nowX, nowY, mask):
  global maskedArea, info, dx, dy, N, M
  paths = []                        # 초기 좌표 초기화
  maskedArea[nowX][nowY] = mask
  paths = [(nowX,nowY)]
  
  queue = deque([(nowX, nowY)])
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nextX, nextY = x+dx[i], y+dy[i]
      if nextX < 0 or nextY < 0 or nextX >= N or nextY >= M:
        continue                    # 영역 벗어나는지 확인
      if maskedArea[nextX][nextY] == 0:
        paths.append((nextX, nextY))
        queue.append((nextX, nextY))  # 영역 저장
        maskedArea[nextX][nextY] = mask    # 마스킹
  
  # 마스킹 정보 저장
  info[mask] = len(paths)
  

# N, M
N, M = map(int, input().split())
# 보드
board = []
for _ in range(N):
  board.append(list(map(int, input().rstrip())))
# 이동 벡터
dx, dy = [1,-1,0,0], [0,0,1,-1]

# 마스킹
maskedArea = copy.deepcopy(board)
info = {}         # 마스킹 영역 정보
info[1] = 0
mask = 2
for x in range(N):
  for y in range(M):
    if maskedArea[x][y] == 0:
      findMaskedArea(x, y, mask)
      mask+=1
      
# 탐색
result = [[0]*M for _ in range(N)]
for x in range(N):
  for y in range(M):
    if board[x][y] == 1:
      result[x][y] = 1
      nearMaskedArea = set()      # 인접한 마스킹 영역 확인
      for i in range(4):
        nextX, nextY = x+dx[i], y+dy[i]
        if nextX < 0 or nextY < 0 or nextX >= N or nextY >= M:
          continue
        nearMaskedArea.add(maskedArea[x+dx[i]][y+dy[i]])
      for mask in nearMaskedArea:
        result[x][y] += info[mask]
        
# Output
for x in range(N):
  for y in range(M):
    print(result[x][y]%10, end='')
  print()