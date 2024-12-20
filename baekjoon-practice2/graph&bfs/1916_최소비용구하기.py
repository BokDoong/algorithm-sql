import heapq
import sys
input = sys.stdin.readline

# Input
# 노드, 간선
N = int(input())
M = int(input())
# 그래프
graph = [[] for _ in range(N+1)]
for _ in range(M):
  node1, node2, cost = map(int, input().split())
  graph[node1].append((node2, cost))
# 시작, 끝
start, end = map(int, input().split())
# 거리 정보 담을 딕셔너리
distances = {}
for i in range(1, N+1):
  distances[i] = sys.maxsize


# Main
# 거리-노드 담는 큐
queue = []
heapq.heappush(queue, (0, start))

# 다익스트라 사용
distances[start] = 0
while queue:
  # 최소 거리 노드
  dist, node = heapq.heappop(queue)
  
  # 이미 방문했는지 체크
  if distances[node] < dist:
    continue
  
  # 인접노드 체크
  for node_info in graph[node]:
    cost = dist + node_info[1]
    if cost < distances[node_info[0]]:
      distances[node_info[0]] = cost
      heapq.heappush(queue, (cost, node_info[0]))


# Output
print(distances[end])