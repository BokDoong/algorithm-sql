def solve(n):
  target = 0
  i = 1
  while True:
    target = target * 10 + 1
    target = target % n
    if target == 0:
      print(i)
      break
    i += 1


while True:
  try:
    n = int(input())
    solve(n)
  except:
    break