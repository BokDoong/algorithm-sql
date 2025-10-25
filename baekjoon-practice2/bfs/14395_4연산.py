from collections import deque
import sys
input = sys.stdin.readline

def canGo(num):
  if -(t**0.5) <= num <= t**2:
    return True
  return False

s, t = map(int, input().split())
if s == t:
  print(0)
  exit()

visited = set()
queue = deque([(s, '')])
while queue:
  num, orders = queue.popleft()
  if num == t:
    print(orders)
    exit()
  
  nextNum = num*num
  if canGo(nextNum) and nextNum not in visited:
    visited.add(nextNum)
    queue.append((nextNum, orders+'*'))
  
  nextNum = num+num
  if canGo(nextNum) and nextNum not in visited:
    visited.add(nextNum)
    queue.append((nextNum, orders+'+'))
    
  nextNum = num-num
  if canGo(nextNum) and nextNum not in visited:
    visited.add(nextNum)
    queue.append((nextNum, orders+'-'))
    
  if num != 0:
    nextNum = num/num
    if canGo(nextNum) and nextNum not in visited:
      visited.add(nextNum)
      queue.append((nextNum, orders+'/'))
      
print(-1)