t = int(input())
for _ in range(t):
  m, n, x, y = map(int, input().split())
  x -= 1
  y -= 1
  target = x
  while target<m*n:
    if target%n == y:
      print(target+1)
      break
    target+=m
  else:
    print(-1)