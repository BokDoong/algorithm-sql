# Input
N = int(input())
nums = [[0] for _ in range(N)]
for i in range(N):
  nums[i] = list(map(int, input().split()))
  
# Main
dp = [[0] * N for _ in range(N)]
dp[0][0] = nums[0][0]

# N이 1인 경우
if N == 1:
  print(dp[0][0])
  exit()
  
# N이 2 이상
dp[1][0] = dp[0][0] + nums[1][0]
dp[1][1] = dp[0][0] + nums[1][1]

# 3층부터, 층마다
for i in range(2, N):
  # 처음, 끝 처리
  dp[i][0] = dp[i-1][0] + nums[i][0]
  dp[i][i] = dp[i-1][i-1] + nums[i][i]
  
  # 가운데 처리
  for j in range(1, i):
    dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + nums[i][j]
    
# Output
print(max(dp[N-1]))