from collections import deque
import sys
input = sys.stdin.readline

# N, M
N, M = map(int, input().split())
# 맵
maps = [list(map(int, input().rstrip())) for _ in range(N)]
# 결과 좌표(마지막 인덱스는 벽 부순횟수)
result = [[[0,0] for _ in range(M)] for _ in range(N)]
result[0][0][0] = 1

# 이동 벡터
dx = [1,-1,0,0]
dy = [0,0,1,-1]
# 이동 큐 : (x, y, 벽부순횟수)
queue = deque([(0,0,0)])

# 이동
while queue:
  x, y, brokenWall = queue.popleft()    # x, y, 벽 부순횟수

  # 종료
  if x == N-1 and y == M-1:
    print(result[x][y][brokenWall])
    exit()
    
  # 탐색
  for i in range(4):
    nextX, nextY = x+dx[i], y+dy[i]   # 다음 노드
    
    if nextX < 0 or nextY < 0 or nextX >= N or nextY >= M:
      continue    # 벗어나는지 확인
    
    # 벽이었는데 아직 부순적 없으면 부수기
    if maps[nextX][nextY] == 1 and brokenWall == 0:
      result[nextX][nextY][1] = result[x][y][0]+1
      queue.append((nextX, nextY, 1))
    # 벽아니고 방문한적 없으면 이동
    if maps[nextX][nextY] == 0 and result[nextX][nextY][brokenWall] == 0:
      result[nextX][nextY][brokenWall] = result[x][y][brokenWall]+1
      queue.append((nextX, nextY, brokenWall))
      
print(-1)