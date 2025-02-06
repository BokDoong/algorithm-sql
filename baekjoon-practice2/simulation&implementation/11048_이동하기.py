from collections import deque
import sys
input = sys.stdin.readline

# N, M
N, M = map(int, input().split())
# 미로
maze = [[0 for _ in range(M+1)]]
for _ in range(N):
  maze.append([0]+list(map(int, input().split())))
# 결과 배열
result = [[0]*(M+1) for _ in range(N+1)]

# DP
for i in range(1, N+1):
  for j in range(1, M+1):
    result[i][j] = max(result[i-1][j], result[i][j-1])+maze[i][j]
    
# 결과
print(result[N][M])