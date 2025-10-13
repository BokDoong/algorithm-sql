from collections import deque
import sys
input = sys.stdin.readline

def canGo(x,y):
  if 1 <= x <= N and 1 <= y <= M:
    return True
  return False

N, M = map(int, input().split())
startX, startY = map(int, input().split())
endX, endY = map(int, input().split())

board = [[-1 for _ in range(M+1)]]
for _ in range(N):
  tmp = [-1] + list(map(int,input().split()))
  board.append(tmp)
  
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
  
queue = deque([(0, startX, startY, 0)])   # 현재 부순 횟수, X, Y, 시간 
visited = set([(0, startX, startY)])    # 방문 배열 : (부순 횟수, X, Y)

while queue:
  breakCnt, nowX, nowY, time = queue.popleft()
  
  # 끝
  if nowX == endX and nowY == endY:
    print(time)
    exit()
    
  # 이동
  for i in range(4):
    nextX, nextY = nowX + dx[i], nowY + dy[i]
    
    # 못가면 패스
    if not canGo(nextX, nextY):
      continue
    
    # 벽이라면 부술 수 있는지 체크하고 이동
    if board[nextX][nextY] == 1:
      if breakCnt == 0 and (0, nextX, nextY) not in visited:
        visited.add((0, nextX, nextY))
        queue.append((1, nextX, nextY, time+1))
    # 벽 아니라면 이동
    else:
        if (breakCnt, nextX, nextY) not in visited:
          visited.add((breakCnt, nextX, nextY))
          queue.append((breakCnt, nextX, nextY, time+1))
          
print(-1)