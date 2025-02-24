import sys
input = sys.stdin.readline

# 동전 종류 N, 가치 K
N, K = map(int, input().split())
# 동전
coins = []
for _ in range(N):
  coins.append(int(input().rstrip()))
# DP
DP = [0]*(K+1)

# 처음 값
for k in range(K+1):
  if k%coins[0]==0:
    DP[k] = 1
# 두 번째부터
for x in range(1, N):
  coin = coins[x]
  for y in range(coin, K+1):
      DP[y] = DP[y]+DP[y-coin]

print(DP[K])