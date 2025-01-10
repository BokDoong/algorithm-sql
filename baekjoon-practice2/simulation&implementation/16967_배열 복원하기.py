import copy
import sys
input = sys.stdin.readline


# Input
H, W, X, Y = map(int, input().split())
B = []
for _ in range(H+X):
  B.append(list(map(int, input().split())))
  

# Main
# B를 A로 복제
A = copy.deepcopy(B)

# 겹치는 부분 계산
for i in range(X, H):
  for j in range(Y, W):
    A[i][j] = B[i][j] - A[i-X][j-Y]
    
# Output
for i in range(H):
  for j in range(W):
    print(A[i][j], end = ' ')
  print()