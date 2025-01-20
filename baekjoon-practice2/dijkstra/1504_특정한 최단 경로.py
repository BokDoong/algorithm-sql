import heapq
import sys
input = sys.stdin.readline


# Methods
def calculate(start, end):
  global graph, N
  
  # 거리 저장
  distances = [sys.maxsize] * (N+1)   # 노드까지 거리 저장하는 배열
  distances[start] = 0    # 시작점 초기화
   
  # 힙 초기화
  queue = []
  heapq.heappush(queue, (0, start))
  
  # 최소 거리
  while queue:
    # 거리, 노드
    dist, node = heapq.heappop(queue)
    if distances[node] < dist:
      continue
    
    # 인접 노드
    for near_node_info in graph[node]:
      cost = dist+near_node_info[1]
      near_node = near_node_info[0]
      if distances[near_node] > cost:
        distances[near_node] = cost
        heapq.heappush(queue, (cost, near_node))
    
  return distances[end]

# Input
N, E = map(int, input().split())
graph = [[] for _ in range(N+1)]

# 그래프 : (연결된 노드, 비용)
for _ in range(E):
  a, b, c = map(int, input().split())
  graph[a].append((b,c))
  graph[b].append((a,c))
  
# 거쳐하는 정점
v1, v2 = map(int, input().split())


# Main
# start ~ v1,v2
start_v1 = calculate(1, v1)
start_v2 = calculate(1, v2)

# v1 ~ v2
v1_v2 = calculate(v1, v2)

# v1,v2 ~ end
v1_N = calculate(v1, N)
v2_N = calculate(v2, N)


# Output
result = min(start_v1+v1_v2+v2_N, start_v2+v1_v2+v1_N)
print(result if result < sys.maxsize else -1)