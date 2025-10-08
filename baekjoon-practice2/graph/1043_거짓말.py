import sys
input = sys.stdin.readline

N, M = map(int, input().split())

genuines, bans = list(map(int, input().split())), []

# 1. 그래프 구성 with 연결리스트 (50)
graph = [set() for _ in range(N+1)]
for i in range(1, len(genuines)-1):
  graph[genuines[i]].add(genuines[i+1])
  graph[genuines[i+1]].add(genuines[i])
  
parties = []
for _ in range(M):
  connected = list(map(int, input().split()))
  num, nodes = connected[0], connected[1:]
  if num > 1:
    for i in range(len(nodes)-1):
      if nodes[i+1] not in graph[nodes[i]]:
        graph[nodes[i]].add(nodes[i+1])
        graph[nodes[i+1]].add(nodes[i])
  parties.append(connected)
  
# 2-1. 아무도 없으면 끝
if genuines[0] == 0:
  print(M)
  exit()

# 2-2. 그래프 DFS로 순회하며 bans에 추가 (50*50)
def dfs(node):
  global visited, graph, bans
  
  connectedNodes = graph[node]
  for nextNode in connectedNodes:
    if not visited[nextNode] and nextNode not in bans:
      visited[nextNode] = True
      bans.add(nextNode)
      dfs(nextNode)
      
  return

start = genuines[1]
bans = set([start])
visited = [False] * (N+1)
visited[start] = True
dfs(start)

# 3. 파티정보 순회하며 bans에 있는지 확인 (50*50)
result = 0
for partyInfo in parties:
  num, people = partyInfo[0], partyInfo[1:]
  canLie = True
  for p in people:
    if p in bans:
      canLie = False
      break
  if canLie:
    result+=1
    
print(result)