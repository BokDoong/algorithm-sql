from collections import deque
import sys
input = sys.stdin.readline

# 입력
N = int(input().rstrip())
firstPaper = [list(map(int, input().split())) for _ in range(N)]

# 결과
answer = {-1:0, 0:0, 1:0}

# 같은 숫자로만 채워진지 확인
def isUniform(x, y, size):
  base = firstPaper[x][y]
  for i in range(x, x + size):
    for j in range(y, y + size):
      if firstPaper[i][j] != base:
        return None
  return base

# 분할 정복
def divdeAndConquer(x, y, size):
  result = isUniform(x, y, size)
  if result is not None:  # 같음
    answer[result] += 1
    return
  
  newSize = size // 3
  for dx in range(3):
    for dy in range(3):
      nx = x + dx*newSize
      ny = y + dy*newSize
      divdeAndConquer(nx, ny, newSize)

# 실행
divdeAndConquer(0, 0, N)

print(answer[-1])
print(answer[0])
print(answer[1])