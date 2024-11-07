from collections import deque

deq = deque([])
t = int(input())
for _ in range(t):
  commands = input().split()
  if commands[0] == 'push':
    deq.append(commands[1])
  elif commands[0] == 'pop':
    if len(deq) > 0:  
      print(deq.popleft())
    else:
      print(-1)
  elif commands[0] == 'front':
    if len(deq) > 0:
      print(deq[0])
    else:
      print(-1)
  elif commands[0] == 'back':
    if len(deq) > 0:
      print(deq[-1])
    else:
      print(-1)
  elif commands[0] == 'size':
    print(len(deq))
  elif commands[0] == 'empty':
    if len(deq) > 0:
      print(0)
    else:
      print(1)