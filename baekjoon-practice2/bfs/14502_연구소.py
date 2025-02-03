from collections import deque
import copy
import sys
input = sys.stdin.readline


# 안전 영역 카운팅
def countSafeAreas(tmpMaps):
  global N, M
  result = 0
  for i in range(N):
    for j in range(M):
      if tmpMaps[i][j] == 0:
        result+=1
  return result

# 독퍼지는 과정 구현 : BFS처럼
def diffuse():
  global maps, poisons, N, M
  dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
  
  tmpMaps = copy.deepcopy(maps)   # 임시 지도
  for x, y in poisons:      # 독 위치 하나씩 오염시킴.
    queue = deque([])
    queue.append((x, y))
    while(queue):
      px, py = queue.popleft()    # 독 위치
      for i in range(4):
        nextPx, nextPy = px+dx[i], py+dy[i]
        if 0 <= nextPx < N and 0 <= nextPy < M and tmpMaps[nextPx][nextPy] == 0:
          tmpMaps[nextPx][nextPy] = 2
          queue.append((nextPx, nextPy))    # 독 퍼짐
  
  return countSafeAreas(tmpMaps)

# 벽 하나씩 세우기
def setWalls(depth, start):
  global maps, maxNum, blanks
  
  # 벽 3개 다 세움  
  if depth == 3:
    maxNum = max(maxNum, diffuse())
    return

  # 하나씩 검사
  for i in range(start, len(blanks)):
    # 이미 방문했는지 확인
    if visited[i]:
      continue
    # 세우기
    visited[i] = True
    maps[blanks[i][0]][blanks[i][1]] = 1
    setWalls(depth+1, i)
    visited[i] = False
    maps[blanks[i][0]][blanks[i][1]] = 0


# N, M
N, M = map(int, input().split())

# 독, 빈칸 위치
poisons = []
blanks = []

# 지도
maps = [[] for _ in range(N)]
for x in range(N):
  tmp = list(map(int, input().split()))
  for y in range(M):
    if tmp[y] == 2:    # 독 위치 저장
      poisons.append((x,y))
    elif tmp[y] == 0:   # 빈칸 위치 저장
      blanks.append((x,y))
    maps[x].append(tmp[y])
    
# 방문했는지 확인하는 배열
visited = [False]*len(blanks)
    
# 결과
maxNum = 0


# Output
setWalls(0, 0)
print(maxNum)