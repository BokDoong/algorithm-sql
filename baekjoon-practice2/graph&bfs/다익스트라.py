import sys
import heapq

# 그래프 : (연결돼있는 노드, 거리)
graph = [[0] for _ in range(9)]
graph[1] = [(2,3), (3,4)]
graph[2] = [(1,3), (3,5), (4,10), (6,9)]
graph[3] = [(1,4), (2,5), (4,8), (5,5)]
graph[4] = [(2,10), (3,8), (5,6), (6,10), (7,7), (8,3)]
graph[5] = [(3,5), (4,6), (7,4)]
graph[6] = [(2,9), (4,10), (8,2)]
graph[7] = [(4,7), (5,4), (8,5)]
graph[8] = [(4,3), (6,2), (7,5)]

# 거리 저장 배열
distances = {
  1 : 0, 
  2 : sys.maxsize,
  3 : sys.maxsize,
  4 : sys.maxsize,
  5 : sys.maxsize,
  6 : sys.maxsize,
  7 : sys.maxsize,
  8 : sys.maxsize
}

# 거리, 노드 저장 우선순위큐, 처음은 1
start = 1
queue = []
heapq.heappush(queue, (0, start))


# Main
while queue:
  # 큐에 있는 가장 적은 거리의 노드
  dist, node = heapq.heappop(queue)
  
  # 이미 방문했으면 넘어가기
  if distances[node] < dist:
    continue
  
  # 인접 노드 확인
  # 현재 노드까지의 거리 + 현재~이웃노드 거리가 더 작으면 업데이트, 큐에 넣기
  for node_info in graph[node]:
    cost = dist+node_info[1]
    if distances[node_info[0]] > cost:
      distances[node_info[0]] = cost
      heapq.heappush(queue, (cost, node_info[0]))
      
      
# Output
print(distances)