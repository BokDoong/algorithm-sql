from collections import deque

# Input
N = int(input())

# Main
deq = deque()
for _ in range(N):
  inputs = input().split()
  command = inputs[0]
  
  if command == 'push':
    deq.append(inputs[1])
  elif command == 'pop':
    if len(deq) > 0:
      print(deq.popleft())
    else:
      print(-1)
  elif command == 'size':
    print(len(deq))
  elif command == 'empty':
    if len(deq) > 0:
      print(0)
    else:
      print(1)
  elif command == 'front':
    if len(deq) > 0:
      print(deq[0])
    else:
      print(-1)
  elif command == 'back':
    if len(deq) > 0:
      print(deq[-1])
    else:
      print(-1)