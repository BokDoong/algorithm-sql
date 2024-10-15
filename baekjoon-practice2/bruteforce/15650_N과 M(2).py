# N,M
n, m = map(int, input().split())
nums = []
visited = [False] * (n+1)

# Back-Tracking
def solve(start):
  if len(nums) == m:
    for num in nums:
      print(num, end=' ')
    print()
    return
  
  for i in range(start, n+1):
    if visited[i]:
      continue
    
    visited[i] = True
    nums.append(i)
    solve(i+1)
    nums.pop()
    visited[i] = False

# Main
solve(1)