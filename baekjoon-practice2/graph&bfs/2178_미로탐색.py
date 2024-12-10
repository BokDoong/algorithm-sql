from collections import deque

# Input & 초기화
N, M = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(input()))

# dx,dy
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# 갈 수 있는 노드인지 확인
def can_move(x, y):
  if 0 <= nextX < N and 0 <= nextY < M and board[nextX][nextY] == '1':
    return True
  return False

# 종착점인지 확인
def is_destination(x, y):
  if x == N-1 and y == M-1:
    return True
  return False


# Main
cnt = 10001
queue = deque([(0,0,1)])
board[0][0] = 0
while queue:
  now = queue.popleft()
  
  # 다음 노드 확인
  for i in range(4):
    nextX = now[0] + dx[i]
    nextY = now[1] + dy[i]
    nowCnt = now[2]
    
    # 갈 수 있는 노드인지 확인
    if can_move(nextX, nextY):
      nextCnt = nowCnt + 1
      if is_destination(nextX, nextY):
        cnt = min(cnt, nextCnt)
      else:
        queue.append((nextX, nextY, nextCnt))
        board[nextX][nextY] = '0'


# Output
print(cnt)