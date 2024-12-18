from collections import deque

# Input
M, N = map(int,input().split())
board = []
for _ in range(N):
  board.append(list(map(int, input())))
  
  
# Functions
# 이동할 수 있는지 체크
def can_move(x, y):
  global N, M, dp
  if 0 <= x < N and 0 <= y < M and dp[x][y] == -1:
    return True
  return False


# Main
# 이동 배열
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
# 벽 부순 정보 담을 배열
dp = [[-1] * M for _ in range(N)]
dp[0][0] = 0

# 탐색
queue = deque([(0,0)])
while queue:
  now = queue.popleft()
  for i in range(4):
    # 다음 노드
    nextX = now[0]+dx[i]
    nextY = now[1]+dy[i]
    
    # 이동
    if can_move(nextX, nextY):
      # 방이면
      if board[nextX][nextY] == 0:
        dp[nextX][nextY] = dp[now[0]][now[1]]
        queue.appendleft((nextX, nextY))
      # 벽이면
      if board[nextX][nextY] == 1:
        dp[nextX][nextY] = dp[now[0]][now[1]]+1
        queue.append((nextX, nextY))
    
    
# Output
print(dp[N-1][M-1])