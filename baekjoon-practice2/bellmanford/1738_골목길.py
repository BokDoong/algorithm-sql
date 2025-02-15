import sys
input = sys.stdin.readline

# 벨만포드
def findPath():
  global N, M, street
  
  # 금품
  gold = [-sys.maxsize]*(N+1)
  gold[1] = 0
  # 경로
  path = [0 for i in range(N+1)]
  
  # 탐색
  for v in range(N):
    for start, dest, cost in street:
      if gold[start] != -sys.maxsize and gold[dest] < gold[start]+cost:
        gold[dest] = gold[start]+cost     # 비용 업데이트
        path[dest] = start     # 경로 정보 업데이트
        # 무한 사이클 확인
        if v == N-1:
          gold[dest] = sys.maxsize

  # 종료
  if gold[N] != sys.maxsize:
    result = [N]
    node = N    # 경로 역추척
    while node != 1:
      node = path[node]
      result.append(node)
    result.reverse()
    print(*result)
  else:
    print(-1)
  return

# 교차하는 지점, 골목길
N, M = map(int, input().split())
# 골목길 정보
street = []
for _ in range(M):
  start, dest, cost = map(int,input().split())
  street.append((start, dest, cost))

# 탐색  
findPath()