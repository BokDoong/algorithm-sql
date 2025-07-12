from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
maze = list(map(int, input().split()))
result = -1

if N == 1:
  result = 0
else:
  DP = [sys.maxsize] * N
  queue = deque([(0, 0)])
  while queue:
    node, depth = queue.popleft()
    # 끝
    if node >= N-1:
      result = depth
      break
    # BFS
    if depth < DP[node]:
      DP[node] = depth
      for i in range(1, maze[node]+1):
        queue.append((node+i, depth+1))
  
print(result)