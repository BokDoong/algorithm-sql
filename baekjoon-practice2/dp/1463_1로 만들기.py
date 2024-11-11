import sys

dp =[sys.maxsize] * 3000001
dp[1] = 0
for i in range(1, 1000001):
  dp[i*3] = min(dp[i*3], dp[i]+1)
  dp[i*2] = min(dp[i*2], dp[i]+1)
  dp[i+1] = min(dp[i+1], dp[i]+1)
  
target = int(input())
print(dp[target])