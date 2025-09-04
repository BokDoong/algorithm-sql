import heapq
import sys
input = sys.stdin.readline

N = int(input())
ramens = []
for _ in range(N):
  deadline, ramen = map(int, input().split())
  ramens.append((ramen, deadline))
  
ramens.sort(key = lambda x : x[1])

heap = []
for i in range(N):
  heapq.heappush(heap, ramens[i][0])
  if len(heap) > ramens[i][1]:
    heapq.heappop(heap)
    
print(sum(heap))