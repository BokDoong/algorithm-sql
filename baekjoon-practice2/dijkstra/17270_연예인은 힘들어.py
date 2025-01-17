import heapq
import sys
input = sys.stdin.readline

# Methods
# 지헌, 성하가 위치한 노드에서 다른 노드까지 걸리는 최소 비용 계산
def calculate(start):
  global V, graph
  
  # 각 노드까지 거리 정보
  distances = [sys.maxsize] * (V+1)
  distances[start] = 0
  
  # 힙 : (거리, 노드)
  queue = []
  heapq.heappush(queue, (0, start))
  
  # 계산
  while queue:
    dist, node = heapq.heappop(queue)
    
    if distances[node] < dist:     # 이미 방문했는지 확인
      continue
    
    for node_info in graph[node]:   # 인접 노드 확인
      near_node = node_info[0]
      cost = node_info[1] + dist
      if distances[near_node] > cost:
        distances[near_node] = cost
        heapq.heappush(queue, (cost, near_node))
        
  # 노드까지 거리정보
  return distances


# Input
# V : 노드, M : 간선
V, M = map(int, input().split())

# 그래프 - 노드 : (인접 노드, 비용)
graph = [[] for _ in range(V+1)]
# a, b : 시작-끝 노드, c : 비용
for _ in range(M):
  a, b, c = map(int, input().split())
  graph[a].append((b, c))
  graph[b].append((a, c))

# J, S : 지헌, 성하
J, S = map(int, input().split())


# Main
distanceJ = calculate(J)
distanceS = calculate(S)

# 합이 최단시간
min = sys.maxsize
for i in range(1, V+1):
  if i == J or i == S:
    continue
  
  if distanceJ[i] + distanceS[i] < min:
    min = distanceJ[i] + distanceS[i]
  
# 약속 장소
result = -1
for i in range(1, V+1):
  if i == J or i == S:
    continue
  
  if distanceJ[i] <= distanceS[i] and distanceS[i]+distanceJ[i] == min:
    if result == -1:
      result = i
    else:
      if distanceJ[i] < distanceJ[result]:
        result = i
      elif distanceJ[i] == distanceJ[result]:
        result = min(result,i)
      

# Output
print(result)