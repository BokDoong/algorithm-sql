from collections import deque

# 이동 가능한지 판단
def can_move(x, y, l, board):
  if 0 <= x < l and 0 <= y < l and board[x][y]==0:
    return True
  return False

# BFS
def bfs(board, startX, startY, destX, destY, l):
  global dx, dy
  
  queue = deque([(startX, startY)])
  board[startX][startY] = 1   # 1: 이미 간곳, 0: 아직 안간 곳
  
  while (queue):
    now = queue.popleft()
    now_status = board[now[0]][now[1]]
    
    # 다음 노드
    for i in range(8):
      nextX = now[0] + dx[i]
      nextY = now[1] + dy[i]
      
      # 도착
      if nextX == destX and nextY == destY:
        print(now_status)
        return

      # 이동
      if can_move(nextX, nextY, l, board):
        board[nextX][nextY] = now_status + 1
        queue.append((nextX, nextY))


# Input
t = int(input())
dx = [1, 2, 1, 2, -1, -2, -1, -2]
dy = [2, 1, -2, -1, 2, 1, -2, -1]


# Main
for _ in range(t):
  l = int(input())
  
  # 체스판, 말 셋팅
  board = [[0]*l for _ in range(l)]
  startX, startY = map(int, input().split())
  destX, destY = map(int, input().split())
  
  # 이미 같은지 체크
  if startX == destX and startY == destY:
    print(0)
  else :
    # 탐색(나이트 이동)
    bfs(board, startX, startY, destX, destY, l)