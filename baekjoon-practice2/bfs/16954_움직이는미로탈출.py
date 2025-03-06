import sys
input = sys.stdin.readline

# 벽 아래 이동
def moveWalls():
  global walls,visited
  nextWalls = set()
  newVisited = [[False]*8 for _ in range(8)] 
  for wallX, wallY in walls:
    if wallX+1 == 8:
      continue
    newVisited[wallX+1][wallY] = True
    nextWalls.add((wallX+1, wallY))
  walls = nextWalls
  visited = newVisited  # 방문 배열 갱신

# 이동
def move(queue):
  global board
  # 다음 위치
  next = []
  for nowX, nowY, depth in queue:
    # 현재 위치가 벽됐는지 검사
    if (nowX, nowY) in walls:
      continue
    # 끝났는지 검사
    if nowX == 0 and nowY == 7:
      print(1)
      exit()
    # 다음 노드
    for i in range(9):
      nextX, nextY = nowX+dx[i], nowY+dy[i]
      if checkWallOrOut(nextX, nextY):
        continue
      if visited[nextX][nextY]:
        continue
      visited[nextX][nextY] = True
      next.append((nextX, nextY, depth+1))
  return next

# 나갔거나 벽인지 검사
def checkWallOrOut(nextX, nextY):
  return nextX < 0 or nextY < 0 or nextX >= 8 or nextY >= 8 or (nextX, nextY) in walls

# 벽 위치
walls = set()
# 보드
board = [[0]*8 for _ in range(8)]
for x in range(8):
  tmp = list(input().rstrip())
  for y in range(8):
    if tmp[y] == '#':
      walls.add((x,y))

# 다음 방향, 현재 욱제 위치
dx, dy = [0,0,-1,-1,-1,0,1,1,1], [0,1,1,0,-1,-1,1,-1,0]
# 방문 배열 
visited = [[False]*8 for _ in range(8)]
# 이동
queue = [(7,0,0)]
while True:
  queue = move(queue)
  if len(queue) == 0:
    print(0)
    break
  moveWalls()
