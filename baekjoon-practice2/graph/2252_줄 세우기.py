from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
connected = [[] for _ in range(N+1)]    # 연결된 노드
inputNodesCnt = [0] * (N+1)   # 진입차수 개수

for _ in range(M):    # 그래프
  start, end = map(int, input().split())
  connected[start].append(end)
  inputNodesCnt[end] += 1
  
queue, result = deque([]), []
for v in range(1, N+1):
  if inputNodesCnt[v] == 0:
    queue.append(v)
    
while queue:
  node = queue.popleft()
  result.append(node)
  for connectedNode in connected[node]:
    inputNodesCnt[connectedNode] -= 1
    if inputNodesCnt[connectedNode] == 0:
      queue.append(connectedNode)

print(*result)