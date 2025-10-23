import sys
input = sys.stdin.readline

T, W = map(int, input().split())
zaDus = [0]
for _ in range(T):
  zaDus.append(int(input().rstrip()))
  
DP = [[0 for _ in range(W+1)] for __ in range(T+1)]
for i in range(1, T+1):
  # 움직일 수 없으면 1일 때만 먹음
  if zaDus[i] == 1:
    DP[i][0] = DP[i-1][0] + 1
  else:
    DP[i][0] = DP[i-1][0]
    
  # 자두 먹기
  for j in range(1, W+1):
    if (zaDus[i] == 1 and j%2 == 0) or (zaDus[i] == 2 and j%2 != 0):
      DP[i][j] = max(DP[i-1][j], DP[i-1][j-1]) + 1
    else:
      DP[i][j] = max(DP[i-1][j], DP[i-1][j-1])
    
print(max(DP[T]))