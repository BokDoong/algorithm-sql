from collections import deque
import sys
input = sys.stdin.readline

# 입력
N, K = map(int, input().split())
tree = [[] for _ in range(N)]
for _ in range(N-1):
  parent, child = map(int, input().split())
  tree[parent].append(child)
apples = list(map(int, input().split()))

# BFS
result, visited = 0, [1] + [0] * (N-1)
queue = deque([(0,0)])
while queue:
  node, visitedCount = queue.popleft()
  if apples[node]:
    result += 1
  for next in tree[node]:
    if visitedCount < K and not visited[next]:
      queue.append((next, visitedCount+1))
      visited[next] = True
      
print(result)