from collections import deque
import sys
input = sys.stdin.readline


N = int(input())
schedules = [0] * 366
for _ in range(N):
  start, end = map(int, input().split())
  for d in range(start, end+1):
    schedules[d] += 1
    
ans = 0
width = 0
height = 0

for d in range(1, 366):
  if schedules[d] > 0:
    width += 1
    height = max(height, schedules[d])
  else:
    if width > 0:
      ans += width * height
      width = 0
      height = 0
      
if width > 0:
  ans += width * height
  
print(ans)