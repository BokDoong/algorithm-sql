from collections import deque
import sys
input = sys.stdin.readline

# DFS
def DFS(node):
  global visited, graph, answer
  for connected in graph[node]:
    if not visited[connected]:
      visited[connected] = True
      answer.append(connected)
      DFS(connected)
  
# BFS
def BFS(start):
  global visited, graph, answer
  queue = deque([start])
  while queue:
    node = queue.popleft()
    if visited[node]:
      continue
    answer.append(node)
    visited[node] = True
    for connected in graph[node]:
      queue.append(connected)

# 정점, 간선, 시작
nodes, vertex, start = map(int,input().split())
# 그래프
graph = [[] for _ in range(nodes+1)]
for _ in range(vertex):
  node1, node2 = map(int,input().split())
  graph[node1].append(node2)
  graph[node2].append(node1)
for node in range(1, nodes+1):
  graph[node].sort()
  
# DFS
visited = [0]*(nodes+1)
visited[start] = True
answer = [start]
DFS(start)
print(*answer)

# BFS
visited = [0]*(nodes+1)
answer = []
BFS(start)
print(*answer)
