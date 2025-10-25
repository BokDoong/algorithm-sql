from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
connected = [[] for _ in range(N+1)]
sonCounts = [0]*(N+1)

for _ in range(M):
  start, end = map(int, input().split())
  sonCounts[end] += 1
  connected[start].append(end)

result, queue = [], deque([])
for i in range(1, N+1):
  if sonCounts[i] == 0:
    queue.append(i)
    
while queue:
  num = queue.popleft()
  result.append(num)
  
  for c in connected[num]:
    sonCounts[c] -= 1
    if sonCounts[c] == 0:
      queue.append(c)
        
print(*result)
