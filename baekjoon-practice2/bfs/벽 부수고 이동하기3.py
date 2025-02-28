from collections import deque
import sys
input = sys.stdin.readline

# 크기 : N/M, 벽 부술 수 있는 횟수 : K
N, M, K = map(int, input().split())
# 맵
board = []
for _ in range(N):
  board.append(list(map(int, input().rstrip())))

# 이동벡터
dx, dy = [1,-1,0,0], [0,0,1,-1]
# 방문 배열
result = [[[0]*(K+1) for _ in range(M)] for __ in range(N)]
result[0][0][0] = 1

# BFS : (낮/밤, x, y, 여태까지 벽 부순 횟수, 깊이)
queue = deque([(0, 0, 0, 0, 1)])
while queue:
  # 낮/밤, x, y, 여태까지 벽 부순 횟수, 깊이
  time, curX, curY, brokenCounts, depth = queue.popleft()
  # 끝
  if curX == N-1 and curY == M-1:
    print(depth)
    exit()
  
  # 이동
  for i in range(4):
    # 다음 노드가 안벗어나는지 검사
    nextX, nextY = curX+dx[i], curY+dy[i]
    if nextX < 0 or nextY < 0 or nextX >= N or nextY >= M:
      continue
    # 벽이면
    if board[nextX][nextY] == 1:
      if time == 0 and brokenCounts < K and result[nextX][nextY][brokenCounts+1] == 0:   # 낮이고 벽 부술 수 있을 때
        result[nextX][nextY][brokenCounts+1] = depth+1
        queue.append((1, nextX, nextY, brokenCounts+1, depth+1))
      elif time == 1 and brokenCounts < K:   # 밤이고 벽 부술 수 있을 때
        result[curX][curY][brokenCounts] = depth+1
        queue.append((0, curX, curY, brokenCounts, depth+1))
    # 빈 공간이면
    else:
      if time == 0 and result[nextX][nextY][brokenCounts] == 0:    # 낮일 때
        result[nextX][nextY][brokenCounts] = depth+1
        queue.append((1, nextX, nextY, brokenCounts, depth+1))
      elif time == 1 and result[nextX][nextY][brokenCounts] == 0:    # 밤일 때
        result[nextX][nextY][brokenCounts] = depth+1
        queue.append((0, nextX, nextY, brokenCounts, depth+1))
        
# 결과
print(-1)