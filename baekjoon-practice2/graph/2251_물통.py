import sys
input = sys.stdin.readline

def dfs(a, b, c):
  global result, A, B, C
  
  if a == 0:
    result.add(c)

  # A -> B
  if a+b > B:
    if not visited[a+b-B][B][c]:
      visited[a+b-B][B][c] = True
      dfs(a+b-B, B, c)
  else:
    if not visited[0][a+b][c]:
      visited[0][a+b][c] = True
      dfs(0, a+b, c)
  
  # A -> C
  if a+c > C:
    if not visited[a+c-C][b][C]:
      visited[a+c-C][b][C] = True
      dfs(a+c-C, b, C)
  else:
    if not visited[0][b][a+c]:
      visited[0][b][a+c] = True
      dfs(0, b, a+c)
  
  # B -> A
  if b+a > A:
    if not visited[A][b+a-A][c]:
      visited[A][b+a-A][c] = True
      dfs(A, b+a-A, c)
  else:
    if not visited[b+a][0][c]:
      visited[b+a][0][c] = True
      dfs(b+a, 0, c)
  
  # B -> C
  if b+c > C:
    if not visited[a][b+c-C][C]:
      visited[a][b+c-C][C] = True
      dfs(a, b+c-C, C)
  else:
    if not visited[a][0][b+c]:
      visited[a][0][b+c] = True
      dfs(a, 0, b+c)
  
  # C -> A
  if c+a > A:
    if not visited[A][b][c+a-A]:
      visited[A][b][c+a-A] = True
      dfs(A, b, c+a-A)
  else:
    if not visited[c+a][b][0]:
      visited[c+a][b][0] = True
      dfs(c+a, b, 0)
  
  # C -> B
  if c+b > B:
    if not visited[a][B][c+b-B]:
      visited[a][B][c+b-B] = True
      dfs(a, B, c+b-B)
  else:
    if not visited[a][c+b][0]:
      visited[a][c+b][0] = True
      dfs(a, c+b, 0)

A, B, C = map(int, input().split())

visited = [[[False for _ in range(201)] for __ in range(201)] for ___ in range(201)]
visited[0][0][C] = True

result = set()
dfs(0, 0, C)

result = list(result)
result.sort()
print(*result)