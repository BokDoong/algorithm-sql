# Input
N = int(input())
nums = [0]
for _ in range(N):
  nums.append(int(input()))
  
# Main
dp = [0]
dp.append(nums[1])
if N > 1:
  dp.append(nums[1]+nums[2])
  for i in range(3, N+1):
    dp.append(max(dp[i-1], dp[i-3] + nums[i] + nums[i-1], nums[i]+dp[i-2]))

# Output
print(dp[N])