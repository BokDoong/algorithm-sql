from collections import deque
import sys
input = sys.stdin.readline

def bfs():
  global visited, queue, answer
  
  while queue:
    a, b, c = queue.popleft()
    
    if visited[a][b][c]:
      continue
    visited[a][b][c] = True
    
    if a == 0:
      answer.append(c)
    
    # A -> B
    if a+b > B:
      queue.append((a+b-B, B, c))
    else:
      queue.append((0, a+b, c))
    
    # A -> C
    if a+c > C:
      queue.append((a+c-C, b, C))
    else:
      queue.append((0, b, a+c))
    
    # B -> C
    if b+c > C:
      queue.append((a, b+c-C, C))
    else:
      queue.append((a, 0, b+c))
    
    # B -> A
    if b+a > A:
      queue.append((A, b+a-A, c))
    else:
      queue.append((a+b, 0, c))
    
    # C -> A
    if c+a > A:
      queue.append((A, b, c+a-A))
    else:
      queue.append((a+c, b, 0))
    
    # C -> B
    if c+b > B:
      queue.append((a, B, c+b-B))
    else:
      queue.append((a, b+c, 0))
    

A, B, C = map(int, input().split())
visited = [[[False for _ in range(201)] for __ in range(201)] for ___ in range(201)]

answer = []
queue = deque([(0,0,C)])
bfs()

answer.sort()
print(*answer)