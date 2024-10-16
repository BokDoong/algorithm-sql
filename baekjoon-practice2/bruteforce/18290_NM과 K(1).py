# 입력
n, m, k = map(int, input().split())
board = []
for _ in range(n):
  board.append(list(map(int, input().split())))

result = -2147483647
visited = [[False] * m for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


# Brute-Force
def solve(prevX, prevY, depth, total):
  if depth == k:
    global result
    result = max(result, total)
    return
  
  for x in range(prevX, n):
    for y in range(prevY if x == prevX else 0, m):
      if visited[x][y]:
        continue
      ok = True
      for i in range(4):
        nextX = x + dx[i]
        nextY = y + dy[i]
        if 0 <= nextX < n and 0 <= nextY < m:
          if visited[nextX][nextY]:
            ok = False
      
      if ok:
        visited[x][y] = True
        solve(x, y, depth+1, total+board[x][y])
        visited[x][y] = False
      

# Main
solve(0, 0, 0, 0)
print(result)