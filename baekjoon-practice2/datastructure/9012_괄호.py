from collections import deque

def solve(ps):
  dq = deque(ps)
  cnt = 0
  while len(dq) > 0:
    if dq.popleft() == '(':
      cnt += 1
    else:
      cnt -= 1
      
    if cnt < 0:
      return False
  
  if cnt == 0:
    return True
  else:
    return False

t = int(input())
while t>0:
  ps = input()
  if solve(ps):
    print('YES')
  else:
    print('NO')
  t -= 1