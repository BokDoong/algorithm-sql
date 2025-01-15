import sys
input = sys.stdin.readline
import heapq

# Input
N, M = map(int, input().split())

# 그래프 : (인접 노드, 거리)
graph = [[] for _ in range(N+1)]
for _ in range(M):
  node1, node2, cost = map(int, input().split())
  graph[node1].append((node2, cost)) 
  graph[node2].append((node1, cost))
  

# Main
# 새로운 그래프 : 인접한 노드만 저장
new_graph = [0] * (N+1)

# 거리 저장할 배열
distances = [0, 0]
for _ in range(N-1):
  distances.append(sys.maxsize)
  
# 최소힙 : (노드까지 거리, 노드)
start = 1
queue = []
heapq.heappush(queue, (0,start))

# 다익스트라
while queue:
  # 노드까지 거리, 노드
  dist, node = heapq.heappop(queue)
  
  # 이미 적은 거리가 계산돼있는지 체크
  if distances[node] < dist:
    continue
  
  # 인접 노드 확인
  for near_node_info in graph[node]:
    cost = near_node_info[1]+dist   # 시작 ~ 인접노드까지 거리
    near_node = near_node_info[0]   # 인접 노드
    
    if cost < distances[near_node]:
      distances[near_node] = cost
      heapq.heappush(queue, (cost, near_node))
      new_graph[near_node] = node


# Output      
result = []  
for i in range(2, N+1):
  result.append((i, new_graph[i]))
  
print(len(result))
for (a, b) in result:
  print(a, b)