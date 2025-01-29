import sys
input = sys.stdin.readline


# Methods
def solve(val, depth, paths):
  global max_num, visited
  
  # 4칸 다 채우면 끝
  if depth == 4:
    max_num = max(max_num, val)
    return
    
  # 이동
  for cx, cy in paths:
    for i in range(4):
      # 다음 노드
      nx, ny = cx + dx[i], cy + dy[i]
      # 범위
      if nx < 0 or ny < 0 or nx >= N or ny >= M:
        continue
      # 이미 방문했는지
      if visited[nx][ny] == 1:
        continue
      # 탐색
      visited[nx][ny] = 1
      solve(val+board[nx][ny], depth+1, paths+[(nx, ny)])
      visited[nx][ny] = 0
  


# Input
N, M = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(map(int, input().split())))
  
  
# Main
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
max_num = 0
visited = [[0] * M for _ in range(N)]

for startX in range(N):
  for startY in range(M):
    visited[startX][startY] = 1
    solve(board[startX][startY], 1, [(startX, startY)])


# Output
print(max_num)