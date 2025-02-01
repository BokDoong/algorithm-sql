import sys
input = sys.stdin.readline

# 백트래킹
def backTracking(depth):
  global N, result
  
  # N개 놓음
  if depth == N:
    result+=1
    return
  
  # 탐색
  for i in range(N):
    if not usedY[i] and not usedPlusXY[depth+i] and not usedMinusXY[N-1+depth-i]:
      usedY[i] = True
      usedPlusXY[depth+i] = True
      usedMinusXY[N-1+depth-i] = True
      backTracking(depth+1)
      usedY[i] = False
      usedPlusXY[depth+i] = False
      usedMinusXY[N-1+depth-i] = False
  

# 퀸의 개수
N = int(input().rstrip())

# y축에 퀸이 있는지 여부
usedY = [False]*N
  
# y=x 축에 퀸이 있는지 여부
usedPlusXY = [False]*(2*(N-1)+1)

# y=-x 축에 퀸이 있는지 여부
usedMinusXY = [False]*(2*(N-1)+1)

# 결과
result = 0


# Output
backTracking(0)
print(result)