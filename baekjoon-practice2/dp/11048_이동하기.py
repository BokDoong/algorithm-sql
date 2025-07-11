import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(map(int,input().split())))
  
DP = [[0]*M for _ in range(N)]
DP[0][0] = board[0][0]
for i in range(1, N):
  DP[i][0] = board[i][0] + DP[i-1][0]
for j in range(1, M):
  DP[0][j] = board[0][j] + DP[0][j-1]
  
for i in range(1, N):
  for j in range(1, M):
    DP[i][j] = board[i][j] + max(DP[i-1][j], DP[i][j-1])
  
print(DP[N-1][M-1])