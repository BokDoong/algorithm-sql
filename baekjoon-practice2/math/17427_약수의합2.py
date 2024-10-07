def gA(num):
  total = 0
  for i in range(1, num+1):
    total += (num//i) * i
  return total

n = int(input())
print(gA(n))
