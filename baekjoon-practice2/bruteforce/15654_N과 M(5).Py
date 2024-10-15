# N, M
n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
result = []
visited = [False] * n

# Back-Tracking
def solve():
  if len(result) == m:
    for r in result:
      print(r, end=' ')
    print()
    return 

  for i in range(0, n):
    if visited[i]:
      continue
    
    visited[i] = True
    result.append(nums[i])
    solve()
    result.pop()
    visited[i] = False

# Main
solve()      