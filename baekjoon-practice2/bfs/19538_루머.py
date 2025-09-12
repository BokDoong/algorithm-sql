from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
graph = [set() for _ in range(N+1)]
for i in range(1, N+1):
  nodes = list(map(int, input().split()))
  for j in range(len(nodes)-1):
    node = nodes[j]
    if node not in graph[i]:
      graph[i].add(node)
    if i not in graph[node]:
      graph[node].add(i)
    
peopleCnt = int(input())
firstPeople = list(map(int, input().split()))

trust, queue = [-1]*(N+1), deque([])
for person in firstPeople:
  trust[person] = 0
  queue.append((person, 0))

while queue:
  person, time = queue.popleft()
  nearNodes = graph[person]
  
  re = []
  for nearNode in nearNodes:
    cnt, nearNearNodes = 0, graph[nearNode]
    for reNode in nearNearNodes:
      if trust[reNode] != -1 and trust[reNode] <= time:
        cnt += 1
    if cnt >= (len(nearNearNodes)/2):
      re.append(nearNode)
      
  for reNode in re:
    if trust[reNode] == -1:
      trust[reNode] = time+1
      queue.append((reNode, time+1))

print(*trust[1:])