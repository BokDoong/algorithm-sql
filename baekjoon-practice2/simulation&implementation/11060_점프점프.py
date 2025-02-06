import sys
input = sys.stdin.readline

# N
N = int(input())
# 미로
maze = list(map(int, input().split()))

# 결과
result = [sys.maxsize] * N
result[0] = 0

# 미로 찾기
for i in range(N):
  for j in range(1,maze[i]+1):
    next = i+j
    if next < N:
      result[next] = min(result[i]+1, result[next])
    
# Output
if result[N-1] == sys.maxsize:
  print(-1)
else:
  print(result[N-1])