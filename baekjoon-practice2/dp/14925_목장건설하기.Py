import sys
input = sys.stdin.readline

land = [[0 for _ in range(1001)] for __ in range(1001)]

M, N = map(int, input().split())
for i in range(1, M+1):
  landInfo = list(map(int, input().split()))
  for j in range(1, N+1):
    land[i][j] = landInfo[j-1]
    
result = 0
dp = [[0 for _ in range(1001)] for __ in range(1001)]
for i in range(1, M+1):
  for j in range(1, N+1):
    if land[i][j] != 0:
      continue
    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
    result = max(result, dp[i][j])
    
print(result)