# Input
n = int(input())
visited = [False for _ in range(21)]
result = []

# Formatting
info = input()
sum_infos = [[False] * n for _ in range(n)]
idx = 0
for s in range(n):
  for e in range(s, n):
    sum_infos[s][e] = info[idx]
    idx += 1

# Check Sum Infos
def check_sum():
  global n, result, sum_infos
  for i in range(n):
    for j in range(i, n):
      total= 0
      for t in range(i, j+1):
        total += result[t]
      if sum_infos[i][j] == '+' and total > 0:
        continue
      elif sum_infos[i][j] == '-' and total < 0:
        continue
      elif sum_infos[i][j] == '0' and total == 0:
        continue
      else:
        return False
  return True
  
# Main
def solve(depth):
  global result, n
  if depth == n:
    if check_sum():
      for r in result:
        print(r, end = ' ')
      exit()
    return
  
  for i in range(-10, 11):
    if visited[i+10]:
      continue
    
    visited[i+10] = True
    result.append(i)
    solve(depth+1)
    result.pop()
    visited[i+10] = False
  
# Output
solve(0)