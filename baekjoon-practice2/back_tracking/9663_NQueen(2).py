import sys
input = sys.stdin.readline

# 백트래킹
def backTracking(depth):
  global N, result, heights, plusXY, minusXY
  
  # 끝
  if depth == N:
    result += 1
    return
  
  # 탐색
  for y in range(N):
    if not heights[y] and not plusXY[depth+y] and not minusXY[y-depth+N-1]:
      heights[y] = True
      plusXY[depth+y] = True
      minusXY[y-depth+N-1] = True
      backTracking(depth+1)
      heights[y] = False
      plusXY[depth+y] = False
      minusXY[y-depth+N-1] = False
      

# N
N = int(input().rstrip())

# 세로 보드
heights = [False]*N
# 대각선 보드
plusXY = [False]*(2*N-1)
minusXY = [False]*(2*N-1)

# 결과
result = 0


# Output
backTracking(0)
print(result)