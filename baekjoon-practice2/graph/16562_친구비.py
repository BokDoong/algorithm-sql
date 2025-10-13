from collections import deque
import sys
input = sys.stdin.readline

def findLowestCostInRelationship(startNode):
  queue = deque([(startNode)])
  lowestCost = sys.maxsize
  
  while queue:
    node = queue.popleft()
    lowestCost = min(lowestCost, costs[node])
    for connectedNode in relationships[node]:
      if not visited[connectedNode]:
        visited[connectedNode] = True
        queue.append(connectedNode)
        
  return lowestCost
    
N, M, k = map(int, input().split())
costs = [0] + list(map(int, input().split()))

relationships = [[] for _ in range(N+1)]
for _ in range(M):
  friend1, friend2 = map(int, input().split())
  relationships[friend1].append(friend2)
  relationships[friend2].append(friend1)
  
visited = [False for _ in range(N+1)]
need = 0

for f in range(1, N+1):
  if not visited[f]:
    visited[f] = True
    lowestCost = findLowestCostInRelationship(f)
    need += lowestCost
    
if need <= k:
  print(need)
else:
  print('Oh no')