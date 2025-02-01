from collections import deque

# Input
N, K = map(int, input().split())
graph = [0] * 100001
graph_infos = [0] * 100001

# 같은 위치에서 시작하는지 판단
if N == K:
  print(0)
  print(N)
  exit()


# Main
# 이동 가능한지 판단
def can_move(x):
  global graph
  
  if 0 <= x < 100001 and graph[x] == 0:
    return True
  return False

# 종착지인지 판단
def is_destination(x):
  global K
  
  if x == K:
    return True
  return False

# 그래프 출력
def extract_paths():
  global K, graph_infos
  
  # 그래프 역추적
  tmp = K
  result = [K]
  while tmp != N:
    v = graph_infos[tmp]
    result.append(v)
    tmp = v
  
  # 출력
  result.reverse()
  for r in result:
    print(r, end=' ')
  
  

# 탐색
queue = deque([N])
graph[N] = 1
while(queue):
  # 현재 위치
  now = queue.popleft()
  
  # 이동할 수 있는지 판단
  paths = []
  for next in [now-1, now+1, now*2]:
    if can_move(next):
      paths.append(next)
            
  # 노드 확인
  for path in paths:
    # 종착지 체크
    if is_destination(path):
      # 몇 초만에 만나는지 출력
      print(graph[now])
      # 간선 정보출력
      graph_infos[path] = now
      extract_paths()
      exit()
    
    # 그래프에 간선 정보 추가
    graph_infos[path] = now
    graph[path] = graph[now] + 1
    queue.append(path)
