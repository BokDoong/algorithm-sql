from collections import deque

# Input & 초기화
N, M = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(map(int,input())))

# dx,dy
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# 갈 수 있는 노드인지 확인
def can_move(x, y):
  if 0 <= nextX < N and 0 <= nextY < M and board[nextX][nextY] == 1:
    return True
  return False


# Main
queue = deque([(0,0,1)])
while queue:
  now = queue.popleft()
  
  # 다음 노드 확인
  for i in range(4):
    nextX = now[0] + dx[i]
    nextY = now[1] + dy[i]
    
    # 갈 수 있는 노드인지 확인
    if can_move(nextX, nextY):
        queue.append((nextX, nextY))
        board[nextX][nextY] = board[now[0]][now[1]] + 1


# Output
print(board[N-1][M-1])