import sys
input =sys.stdin.readline

N, K = map(int, input().split())
goods = [[0]]
for _ in range(N):
  goods.append(list(map(int, input().split())))
  
DP = [[0]*(K+1) for _ in range(N+1)]
for n in range(1, N+1):
  w, v = goods[n]
  DP[n][:w] = DP[n-1][:w]
  for k in range(w, K+1):
    DP[n][k] = max(DP[n-1][k], DP[n-1][k-w] + v)
    
print(DP[N][K])
