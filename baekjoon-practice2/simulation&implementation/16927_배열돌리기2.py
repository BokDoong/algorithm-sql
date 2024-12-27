from collections import deque
import sys
input = sys.stdin.readline

# Input
N, M, R = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(map(int, input().split())))
  
# Main
result = [[0] * M for _ in range(N)]
loop = min(N, M) // 2

for i in range(loop):
    # 1. 껍데기 분리(위-오른쪽-아래-왼쪽)
    deq = deque([])
    deq.extend(board[i][i:M-i]) # 위
    for j in range(i+1, N-i):
      deq.append(board[j][M-i-1]) # 오른쪽
    deq.extend(board[N-i-1][i:M-i-1][::-1]) # 아래
    for j in range(N-i-2, i, -1):
      deq.append(board[j][i]) # 왼쪽
    
    # 2. R 만큼 반시계 회전
    deq.rotate(-R)
    
    # 3. result에 붙이기(위-오른쪽-아래-왼쪽)
    for j in range(i,M-i):
      result[i][j] = deq.popleft()  # 위
    for j in range(i+1, N-i):
      result[j][M-1-i] = deq.popleft() # 오른쪽
    for j in range(M-2-i, i-1, -1):
      result[N-1-i][j] = deq.popleft()  # 아래쪽
    for j in range(N-2-i, i, -1):
      result[j][i] = deq.popleft()  # 왼쪽
      

# Output
for i in range(N):
  for j in range(M):
    print(result[i][j], end=' ')
  print()