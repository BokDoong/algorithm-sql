t = int(input())
while t > 0:
  words = input().split()
  for w in words:
    print(w[::-1], end=' ')
  t -= 1