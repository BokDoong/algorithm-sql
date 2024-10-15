# N, M
n, m = map(int, input().split())
nums = []

# Back-Tracking
def solve():
  if len(nums) == m:
    for num in nums:
      print(num, end=' ')
    print()
    return
  
  for i in range(1, n+1):
    nums.append(i)
    solve()
    nums.pop()

# Main
solve()