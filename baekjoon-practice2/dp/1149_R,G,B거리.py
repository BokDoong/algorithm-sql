# Input
n = int(input())

houses = [[0]*3 for _ in range(n)]
for i in range(n):
  houses[i] = list(map(int, input().split()))

# Main
dp = [[0]*3 for _ in range(n)]
dp[0] = houses[0]

for i in range(1, n):
  dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + houses[i][0]
  dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + houses[i][1]
  dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + houses[i][2]
  
# Output
print(min(dp[n-1][0], dp[n-1][1], dp[n-1][2]))