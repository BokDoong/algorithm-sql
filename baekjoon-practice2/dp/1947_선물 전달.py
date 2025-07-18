import sys
input = sys.stdin.readline

N = int(input())
DP = [0] * (N+1)

if N == 1:
  print(0)
else:
  DP[2] = 1
  for i in range(3, N+1):
    DP[i] = (i-1)*(DP[i-1]+DP[i-2]) % 1000000000
    
  print(DP[N])