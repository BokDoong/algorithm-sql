from collections import deque
import sys
input = sys.stdin.readline

# 반사된 방향 설정
def reflect(x, y):
  if x == 1 or x == -1:
    return 0, -1, 0, 1
  if y == 1 or y == -1:
    return -1, 0, 1, 0
  
# 북:0, 동:1, 남:2, 서:3
def directionToVector(x,y):
  if x == -1 and y == 0:
    return 0
  elif x == 0 and y == 1:
    return 1
  elif x == 1 and y == 0:
    return 2
  else:
    return 3

# 집의 크기
N = int(input().rstrip())
# 문 위치
doors = []
# 집의 정보
house = []
for x in range(N):
  info = list(input().rstrip())
  for y in range(N):
    if info[y] == '#':
      doors.append((x,y))
  house.append(info)
  
# 출발, 도착 문
startDoor = doors[0]
destDoor = doors[1]

# 결과 저장배열
dp = [[[sys.maxsize,sys.maxsize,sys.maxsize,sys.maxsize] for __ in range(N)] for _ in range(N)]
# 큐 초기화
queue = deque([])
startX, startY = startDoor[0], startDoor[1]
queue.append((startX, startY, 1, 0, 0))
queue.append((startX, startY, -1, 0, 0))
queue.append((startX, startY, 0, 1, 0))
queue.append((startX, startY, 0, -1, 0))

# 탐색
while queue:
  x, y, dx, dy, door = queue.popleft()   # 현재 좌표&이동방향, 현재까지 설치한 문 개수
  
  # 이동할 수 있는 방향 뽑기
  nextDx, nextDy = [dx], [dy]
  if house[x][y] == '!':
    dx1, dy1, dx2, dy2 = reflect(dx, dy)
    nextDx.append(dx1); nextDx.append(dx2); nextDy.append(dy1); nextDy.append(dy2)
  
  # 이동
  for i in range(len(nextDx)):
    nextX, nextY = x+nextDx[i], y+nextDy[i]   # 다음 노드
    # 벽인지 or 벗어나는지
    if nextX < 0 or nextY < 0 or nextX >= N or nextY >= N:
      continue
    if house[nextX][nextY] == '*':
      continue
    # 현재까지 설치한 수보다 작으면 업뎃
    if dp[nextX][nextY][directionToVector(nextDx[i],nextDy[i])] > door:
      if i == 0:
        dp[nextX][nextY][directionToVector(nextDx[i],nextDy[i])] = door
        queue.append((nextX, nextY, nextDx[i], nextDy[i], door))
      else:
        dp[nextX][nextY][directionToVector(nextDx[i],nextDy[i])] = door+1
        queue.append((nextX, nextY, nextDx[i], nextDy[i], door+1))
      
      
# 결과
print(min(dp[destDoor[0]][destDoor[1]]))