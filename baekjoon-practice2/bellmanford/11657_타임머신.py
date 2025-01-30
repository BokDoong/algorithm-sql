import sys
input = sys.stdin.readline


# 노드, 간선 개수
N, M = map(int, input().split())

# 간선 정보
edges = []
for _ in range(M):
  sv, ev, cost = map(int, input().split())
  edges.append((sv, ev, cost))    # 시작 노드, 끝 노드, 비용
  
# 최단거리 테이블
distance = [sys.maxsize] * (N+1)

# 벨만-포드 알고리즘
def bellmanFord(start):
  global distance
  
  # 시작 노드
  distance[start] = 0
  # 모든 노드를 돌며 반복
  # v-1번 탐색
  for i in range(N):
    # 모든 간선 확인
    for j in range(M):
      curNode, nextNode, edgeCost = edges[j]
      # 최단 거리 확인
      if distance[curNode] != sys.maxsize and distance[curNode] + edgeCost < distance[nextNode]:
        distance[nextNode] = distance[curNode] + edgeCost
        # 음의 사이클 확인 : v번째 사이클에서도 갱신되면 음의 사이클
        if i == N-1:
          return False
        
  # 정상 종료
  return True

# Main
if bellmanFord(1):
  for i in range(2, N+1):
    if distance[i] == sys.maxsize:
      print(-1)
    else:
      print(distance[i])
else:
  print(-1)