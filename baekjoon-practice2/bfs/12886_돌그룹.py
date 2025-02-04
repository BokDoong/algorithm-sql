from collections import deque
import sys
input = sys.stdin.readline

def solve():
  global A, B, C, total, visited
  
  # 큐
  queue = deque([])
  queue.append((A,B))
  visited[A][B] = True    # 방문 처리
  
  # 큐 빌 때까지
  while queue:
    # 돌
    x, y = queue.popleft()
    z = total - x - y
    
    # 셋 다 같으면 종료
    if x == y == z:
      print(1)
      return
    
    # 두 그룹끼리 돌 수 비교
    for a, b in (x, y), (y, z), (x, z):
      if a < b:
        b -= a
        a *= 2
      elif a > b:
        a -= b
        b *= 2
      else:
        continue    # 같으면 건너뛰기
      
      # 남은 돌의개수
      c = total - a - b
      # 가장 작은 값, 최대 값
      x, y = min(a,b,c), max(a,b,c)
      
      # 방문 처리 & 큐에 추가
      if not visited[x][y]:
        visited[x][y] = True
        queue.append((x,y))
  
  # 없음
  print(0)

# A, B, C
A, B, C = map(int, input().split())
# 전체 돌의 개수
total = A+B+C
# 방문
visited = [[False]*(total+1) for _ in range(total+1)]

# 총 돌의 개수가 3의 배수가 아니라면
if total % 3 != 0:
  print(0)
# 3의 배수라면 
else:
  solve()