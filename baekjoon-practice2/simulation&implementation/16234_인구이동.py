from collections import deque
import sys
input = sys.stdin.readline

# 국경선 공유하는 나라찾기
def findSharedNations(x,y):
  global nations, N, L, R, visited, dx, dy
  
  # 초기화
  sharedNations = [(x,y)]
  queue = deque([])
  queue.append((x,y))
  visited[x][y] = True
  
  # 탐색
  while queue:
    nowX, nowY = queue.popleft()
    for i in range(4):
      nextX, nextY = nowX+dx[i], nowY+dy[i]
      
      if nextX < 0 or nextY < 0 or nextX >= N or nextY >= N:
        continue
      if visited[nextX][nextY]:
        continue
      if L <= abs(nations[nowX][nowY]-nations[nextX][nextY]) <= R:
        queue.append((nextX, nextY))
        visited[nextX][nextY] = True
        sharedNations.append((nextX, nextY))
        
  return sharedNations
        
# 인구이동
def moveHuman(sharedNations):
  global nations
  
  # 평균계산
  total = 0
  for x, y in sharedNations:
    total+=nations[x][y]
  # 인구 셋팅
  avg = int(total/len(sharedNations))
  for x, y in sharedNations:
    nations[x][y]=avg
  

# N, L, R
N, L, R = map(int, input().split())
# 나라(인구 수)
nations = []
for _ in range(N):
  nations.append(list(map(int, input().split())))
  
# 이동 벡터
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
  
# 날짜계산
days = 0
while True:
  visited = [[False]*N for _ in range(N)]
  move = False
  
  # 연합국 찾기
  for i in range(N):
    for j in range(N):
      if not visited[i][j]:
        union = findSharedNations(i, j)   
        if len(union) > 1:
          moveHuman(union)    # 인구이동
          move=True
  # 날짜
  if move:
    days+=1
  else:
    break
  

# Output
print(days)