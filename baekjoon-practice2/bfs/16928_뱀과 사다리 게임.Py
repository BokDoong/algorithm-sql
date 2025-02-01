from collections import deque
import sys
input = sys.stdin.readline

# 사다리, 뱀 칸에 있는지 확인
def check(node):
  global snakes, ladders
  
  # 뱀 칸인지 확인
  for x, y in snakes:
    if x == node:
      return y
  
  # 사다리 칸인지 확인
  for x, y in ladders:
    if x == node:
      return y
  
  return node


# 사다리, 뱀
N, M = map(int, input().split())

# 사다리 정보
ladders = []
for _ in range(N):
  x, y = map(int, input().split())
  ladders.append((x,y))
  
# 뱀의 정보
snakes = []
for _ in range(M):
  x, y = map(int, input().split())
  snakes.append((x,y))
  
# 방문 정보
visited = [False] * 101
  
# 큐 : (노드, 깊이)
queue = deque([])
queue.append((1, 0))

# BFS
while queue:
  node, depth = queue.popleft()
  
  # 도착
  if node == 100:
    print(depth)
    break
  
  # 주사위 굴리기: 1~6
  for i in range(1,7):
    nextNode = node + i
    nextNode = check(nextNode) # 사다리/뱀 칸인지 확인
    
    if nextNode <= 100 and not visited[nextNode]:   # 이미 방문한 곳인지 확인
      visited[nextNode] = True
      queue.append((nextNode, depth+1))    # 큐에 넣기