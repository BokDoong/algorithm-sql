# Input
N = int(input())

# Main
dp = [[0]*10 for _ in range(N+1)]
dp[1] = [1] * 10

for i in range(2, N+1):
  dp[i][0] = 1
  for j in range(1, 10):
    tmp = 0
    for k in range(0, j+1):
      tmp += dp[i-1][k]
    dp[i][j] = tmp % 10007
  
# Output
print(sum(dp[N]) % 10007)