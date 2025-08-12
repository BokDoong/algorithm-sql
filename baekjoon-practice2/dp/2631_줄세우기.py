import sys
input = sys.stdin.readline

N = int(input())
A = [int(input()) for _ in range(N)]
dp = [0] * N

for i in range(N):
  m = 0
  for j in range(i-1, -1, -1):
    if A[i] > A[j]:
      m = max(m, dp[j])
  dp[i] = m+1
  
print(N - max(dp))