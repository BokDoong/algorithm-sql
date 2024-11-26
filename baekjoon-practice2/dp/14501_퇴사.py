# Input
n = int(input())
times = []
prices = []
for _ in range(n):
  t, p = map(int, input().split())
  times.append(t)
  prices.append(p)
  
# Main
dp = [0] * (n+1)
for i in range(n-1, -1, -1):
  next = i + times[i]
  if next > n:
    dp[i] = dp[i+1]
  else:
    dp[i] = max(dp[i+1], prices[i]+dp[next])
  
# Output
print(dp[0])