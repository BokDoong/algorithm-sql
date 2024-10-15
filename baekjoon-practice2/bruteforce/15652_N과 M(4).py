# N, M
n, m = map(int, input().split())
nums = []

# Back-Tracking
def solve(start):
  if len(nums) == m:
    for num in nums:
      print(num, end=' ')
    print()
    return
  
  for i in range(start, n+1):
    nums.append(i)
    solve(i)
    nums.pop()

# Main
solve(1)