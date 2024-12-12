from collections import deque

# Input
N, K = map(int, input().split())
graph = [0] * 100001

# 시작부터 같은지 판단
if N == K:
  print(0)
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
      print(graph[now])
      exit()
    
    graph[path] = graph[now] + 1
    queue.append(path)