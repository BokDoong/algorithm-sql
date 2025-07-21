from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
inbound = [0]*(N+1)
for _ in range(M):
  info = list(map(int, input().split()))
  for i in range(1, info[0]):
    inbound[info[i+1]] += 1
    graph[info[i]].append(info[i+1])

queue = deque([])
for i in range(1, N+1):
  if inbound[i] == 0:
    queue.append(i)

answer = []
while queue:
  node = queue.popleft()
  answer.append(node)
  
  for connectedNode in graph[node]:
    inbound[connectedNode] -= 1
  graph[node] = []
  
  for i in range(1, N+1):
    if inbound[i] == 0 and i not in answer and i not in queue:
      queue.append(i)
      
if len(answer) == N:
  for a in answer:
    print(a)
else:
  print(0)