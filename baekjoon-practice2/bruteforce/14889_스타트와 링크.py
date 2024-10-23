import sys

# Input
n = int(input())
s = [[0] * n for _ in range(n)]
for i in range(n):
  s[i] = list(map(int, input().split()))
visited = [False] * n
result = sys.maxsize

# 능력치 계산
def caculate_diff():
  # 스타트팀 : visited[True]
  start = 0
  for i in range(0, n-1):
    if visited[i]:
      for j in range(i+1, n):
        if visited[j]:
          start += s[i][j] + s[j][i]
  
  # 링크팀 : visited[False]
  link = 0
  for i in range(0, n-1):
    if not visited[i]:
      for j in range(i+1, n):
        if not visited[j]:
          link += s[i][j] + s[j][i]
  
  return abs(start-link)

# 백트래킹
def solve(depth, now):
  if depth == n//2:
    global result
    result = min(caculate_diff(), result)
    return

  for i in range(now, n):
    if visited[i]:
      continue
    
    visited[i] = True
    solve(depth+1, i)
    visited[i] = False
    
solve(0, 0)
print(result)