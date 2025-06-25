import sys
input = sys.stdin.readline

# DFS
def DFS(node, depth, graph, visited):
  # 탐색 끝
  if depth == maxDepth:
    print(*graph)
    exit()
  
  # *2
  next = node*2
  if next in nums and next not in visited:
    visited.add(next)
    graph.append(next)
    DFS(next, depth+1, graph, visited)
    visited.remove(next)
    graph.pop()
    
  # //3
  if node%3 == 0:
    next = node//3
    if next in nums and next not in visited:
      visited.add(next)
      graph.append(next)
      DFS(next, depth+1, graph, visited)
      visited.remove(next)
      graph.pop()
      
# 입력
N = int(input())
nums = set(map(int, input().split()))
maxDepth = len(nums)

for num in nums:
  DFS(num, 1, [num], {num})