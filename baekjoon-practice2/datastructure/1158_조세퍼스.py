from collections import deque

n, k = map(int, input().split())
deq = deque(str(i) for i in range(1, n+1))
result = []

while len(result) < n:
  for _ in range(k-1):
    deq.append(deq.popleft())
  result.append(deq.popleft())
  
print('<' + ', '.join(result) + '>')