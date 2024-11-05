# DFS
def solve(n, nums, depth, visited, start):
  if depth == 6:
    print(' '.join(result))
    return
  
  for i in range(start, n):
    if visited[i]:
      continue
    
    visited[i] = True
    result.append(nums[i])
    solve(n, nums, depth+1, visited, i)
    result.pop()
    visited[i] = False
    
# Main
result = []
visit = []
while True:
  nums = list(input().split())
  if nums[0] == '0':
    break
  visited = [False] * int(nums[0])
  solve(int(nums[0]), nums[1:], 0, visited, 0)
  print()