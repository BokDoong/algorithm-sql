dp = [0] * 1001
dp[1] = 1
dp[2] = 3

for i in range(3, 1001):
  dp[i] = 2*dp[i-2] + dp[i-1]
  
target = int(input())
print(dp[target])