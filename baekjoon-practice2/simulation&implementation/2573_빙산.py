from collections import deque
import sys
input = sys.stdin.readline

def canGo(x, y):
  global N, M
  if x >= 0 and y >= 0 and x < N and y < M:
    return True
  return False

def melt():
  global ices, pole, dx, dy
  
  meltAmount = [[0]*M for _ in range(N)]
  for n, m in ices:
    for i in range(4):
      nextN, nextM = n+dx[i], m+dy[i]
      if canGo(nextN, nextM) and pole[nextN][nextM] == 0:
        meltAmount[n][m] += 1
    
  newIces = []
  for n,m in ices:
      pole[n][m] = max(0, pole[n][m] - meltAmount[n][m])
      if pole[n][m] > 0:
          newIces.append((n,m))
  ices[:] = newIces


def checkMount():
  global pole, N, M, dx, dy
  visited, separated = [[False]*M for _ in range(N)], False
  
  for n in range(N):
    for m in range(M):
      if pole[n][m] > 0 and not visited[n][m]:
        if separated:
          return False
        separated = True
          
        queue = deque([(n,m)])
        visited[n][m] = True
        while queue:
          iceN, iceM = queue.popleft()
          for i in range(4):
            nextIceN, nextIceM = iceN+dx[i], iceM+dy[i]
            if canGo(nextIceN, nextIceM) and pole[nextIceN][nextIceM] > 0 and not visited[nextIceN][nextIceM]:
              visited[nextIceN][nextIceM] = True
              queue.append((nextIceN, nextIceM))
  
  return True
      

N, M = map(int, input().split())
pole = [list(map(int, input().split())) for _ in range(N)]
dx, dy = [1,0,-1,0], [0,1,0,-1]

ices = []
for n in range(N):
  for m in range(M):
    if pole[n][m] > 0:
      ices.append((n,m))
    
year = 0
while True:
    year += 1
    melt()

    # 1) 빙산이 전부 녹았으면 0 출력
    if not ices:
        print(0)
        break

    # 2) 두 덩어리 이상 분리되었으면 경과년수 출력
    if not checkMount():
        print(year)
        break