# 입력 
nums = []
n, m = map(int, input().split())
visited = [False] * (n+1)

# 완전 탐색
def solve():
  if len(nums) == m:
    for num in nums:
      print(num, end=' ')
    print()
    return
  
  for i in range(1, n+1):
    if visited[i]:
      continue
    
    visited[i] = True
    nums.append(i)
    solve()
    nums.pop()
    visited[i] = False

# Main
solve()