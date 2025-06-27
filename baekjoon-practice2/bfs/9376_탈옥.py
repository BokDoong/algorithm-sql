import sys
from collections import deque

tc = int(input())

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def bfs(y,x):
  visited = [[-1]*(w+2) for _ in range(h+2)]
  dq = deque()
  dq.append([y,x])
  visited[y][x] = 0
  while dq:
    y, x = dq.popleft()
    for i in range(4):
      ny = y + dy[i]
      nx = x + dx[i]
      if 0 <= ny <= h+1 and 0 <= nx <= w+1:
        if visited[ny][nx] == -1:
          if board[ny][nx] == '.' or board[ny][nx] == '$':
            visited[ny][nx] = visited[y][x]
            dq.appendleft([ny,nx])
          elif board[ny][nx] == '#':
            visited[ny][nx] = visited[y][x] + 1
            dq.append([ny,nx])
  return visited

for _ in range(tc):
  h, w = map(int, input().split())
  board = [list('.'*(w+2))]
  for i in range(h):
    board.append(list('.' + input().strip() + '.'))
  board.append(list('.'*(w+2)))
  
  prisoner = []
  for i in range(h+2):
    for j in range(w+2):
      if board[i][j] == '$':
        prisoner.append([i,j])
        
  one = bfs(prisoner[0][0], prisoner[0][1])
  two = bfs(prisoner[1][0], prisoner[1][1])
  sang = bfs(0,0)
  answer = sys.maxsize
  
  for i in range(h+2):
    for j in range(w+2):
      if one[i][j] != -1 and two[i][j] != -1 and sang[i][j] != -1:
        result = one[i][j] + two[i][j] + sang[i][j]
        if board[i][j] == '*':
          continue
        if board[i][j] == '#':
          result -= 2
        answer = min(answer, result)
        
  print(answer)