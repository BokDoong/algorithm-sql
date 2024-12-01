import copy

# Input
N = int(input())
nums = list(map(int,input().split()))

# Main
dp = copy.deepcopy(nums)

for i in range(1, N):
  for j in range(i):
    if nums[j] < nums[i]:
      dp[i] = max(dp[i], dp[j]+nums[i])
  
# Output
print(max(dp))