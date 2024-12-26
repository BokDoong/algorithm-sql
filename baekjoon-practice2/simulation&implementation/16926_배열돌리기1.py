from collections import deque
import sys
input = sys.stdin.readline

# Main
def rotate():
  global board, N, M, answer
  deq = deque()
  
  # 껍데기 수
  loop = min(N,M) // 2
  # 껍데기 생성
  for i in range(loop):
    deq.clear()
    deq.extend(board[i][i:M-i])   # 위쪽
    deq.extend([row[M-i-1] for row in board[i+1:N-i-1]])  # 오른쪽
    deq.extend(board[N-i-1][i:M-i][::-1]) # 아래쪽
    deq.extend([row[i] for row in board[i+1:N-i-1][::-1]])  # 왼쪽
    # 반대방향 회전
    deq.rotate(-R)
    
    for j in range(i, M-i):                 # 위쪽
        answer[i][j] = deq.popleft()
    for j in range(i+1, N-i-1):             # 오른쪽
        answer[j][M-i-1] = deq.popleft()
    for j in range(M-i-1, i-1, -1):           # 아래쪽
        answer[N-i-1][j] = deq.popleft()  
    for j in range(N-i-2, i, -1):           # 왼쪽
        answer[j][i] = deq.popleft() 

# Input
N, M, R = map(int, input().split())
board = []
for i in range(N):
  board.append(list(map(int, input().split())))


# Output
answer = [[0]*M for _ in range(N)]
rotate()
for i in range(N):
  for j in range(M):
    print(answer[i][j], end=' ')
  print()