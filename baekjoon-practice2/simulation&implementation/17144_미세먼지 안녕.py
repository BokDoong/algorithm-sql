from collections import deque
import sys
input = sys.stdin.readline

# 변화량 계산
def calculate(delta):
  global room, R, C
  
  for x in range(R):
    for y in range(C):
      room[x][y] = room[x][y]+delta[x][y]

# 미세먼지 합
def calculateMessSum():
  global room 
  
  total = 0
  for r in range(R):
    for c in range(C):
      total += room[r][c]
  
  return total

# 미세먼지 찾기
def findMess():
  global room, R, C
  
  mess = []
  for r in range(R):
    for c in range(C):
      if room[r][c] > 0:
        mess.append((r,c))
        
  return mess

# 미세먼지 확산
def diffuse():
  global room
  
  # 미세먼지 위치, 이동벡터
  mess = findMess()
  dx, dy = [0,0,-1,1], [1,-1,0,0]
  # 변화량
  delta = [[0]*C for _ in range(R)]
  
  # 확산
  for x, y in mess:
    amount = room[x][y]//5    # 확산되는 미세먼지 양
    move = 0    # 움직일 수 있는 위치 개수
    
    # 4방향으로 확산
    for i in range(4):
      nextX, nextY = x+dx[i], y+dy[i]
      if nextX < 0 or nextY < 0 or nextX >= R or nextY >= C:    # 벗어남
        continue
      if room[nextX][nextY] == -1:    # 공기청정기
        continue
      delta[nextX][nextY] = delta[nextX][nextY]+amount    # 확산
      move += 1
    # 남은 미세먼지 계산
    delta[x][y] = delta[x][y] - amount*move
    
  # 변화량 계산
  calculate(delta)
  
  
# 위쪽 공기청정기 작동
def operateUpward():
  global room, machine, R, C
  
  x, y = machine[0]       # 공기청정기
  messInfo = deque([])    # 미세먼지
  
  for i in range(y+1, C):
    messInfo.append(room[x][i])
  for i in range(x-1, -1, -1):
    messInfo.append(room[i][C-1])
  for i in range(C-2, y-1, -1):
    messInfo.append(room[0][i])
  for i in range(1, x):
    messInfo.append(room[i][y])   # 반시계
  
  messInfo.appendleft(0)    # 회전
  messInfo.pop()
  
  for i in range(y+1, C):
    room[x][i] = messInfo.popleft()
  for i in range(x-1, -1, -1):
    room[i][C-1] = messInfo.popleft()
  for i in range(C-2, y-1, -1):
    room[0][i] = messInfo.popleft()
  for i in range(1, x):
    room[i][y] = messInfo.popleft()            # 반시계
    
# 아래쪽 공기청정기 작동
def operateDownward():
  global room, machine, R, C
  
  x, y = machine[1]       # 공기청정기
  messInfo = deque([])    # 미세먼지
  
  for i in range(y+1, C):
    messInfo.append(room[x][i])
  for i in range(x+1, R):
    messInfo.append(room[i][C-1])
  for i in range(C-2, y-1, -1):
    messInfo.append(room[R-1][i])
  for i in range(R-2, x, -1):
    messInfo.append(room[i][y])   # 반시계
  
  messInfo.appendleft(0)    # 회전
  messInfo.pop()
  
  for i in range(y+1, C):
    room[x][i] = messInfo.popleft()
  for i in range(x+1, R):
    room[i][C-1] = messInfo.popleft()
  for i in range(C-2, y-1, -1):
    room[R-1][i] = messInfo.popleft()
  for i in range(R-2, x, -1):
    room[i][y] = messInfo.popleft()           # 반시계
    

# R, C, T
R, C, T = map(int, input().split())
# 미세먼지
mess = set()
# 공기청정기 : 위, 아래
machine = []
# 방
room = []
for x in range(R):
  info = list(map(int, input().split()))
  for y in range(C):
    if info[y] == -1:
      machine.append((x,y))
  room.append(info)
  
# 시간 지남
for _ in range(T):
  diffuse()
  operateUpward()
  operateDownward()
  
# 결과
print(calculateMessSum()+2)