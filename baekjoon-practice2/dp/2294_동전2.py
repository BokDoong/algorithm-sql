import sys
input = sys.stdin.readline

# 동전 개수 n, 합 k
n,k = map(int, input().split())
# 동전
arr = []
for _ in range(n):
  arr.append(int(input().rstrip()))
  
# DP
dp = [10001 for _ in range(k+1)]
dp[0]=0
for coin in arr:
  for x in range(coin, k+1):
    dp[x] = min(dp[x], dp[x-coin]+1)
    
# 결과
if dp[k] == 10001:
  print(-1)
else:
  print(dp[k])