from collections import deque
import sys
input = sys.stdin.readline

# N,M,K
N,M,K = map(int, input().split())
# 보드
board = []
for _ in range(N):
  board.append(list(map(int, input().rstrip())))
  
# BFS
queue = deque([(0,0,0)])   # 큐: (X,Y,부순수)
result = [[[0]*(K+1) for _ in range(M)] for __ in range(N)]
result[0][0][0] = 1        # 결과 배열
dx, dy = [1,-1,0,0], [0,0,1,-1]   # 이동 벡터
# 탐색
while queue:
  x, y, brokenWalls = queue.popleft()
  depth = result[x][y][brokenWalls]
  for i in range(4):
    nextX, nextY = x+dx[i], y+dy[i]
    if nextX < 0 or nextY < 0 or nextX >= N or nextY >= M:
      continue    # 범위 벗어나는지 확인
    # 벽인 경우
    if board[nextX][nextY] == 1:
      if brokenWalls+1 <= K and result[nextX][nextY][brokenWalls+1] == 0:    # 부술 수 있으면 부수고 가기
        result[nextX][nextY][brokenWalls+1] = depth+1
        queue.append((nextX, nextY, brokenWalls+1))
    # 벽 아님
    else:
      if result[nextX][nextY][brokenWalls] == 0:
        result[nextX][nextY][brokenWalls] = depth+1
        queue.append((nextX, nextY, brokenWalls))

# 결과
answer = set(result[N-1][M-1])
if answer == {0}:
  print(-1)
else:
  if 0 in answer:
    answer.remove(0)
  print(sorted(list(answer))[0])