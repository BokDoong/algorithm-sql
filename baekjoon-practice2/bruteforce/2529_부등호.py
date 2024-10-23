def good(x, y, op):
  if op == '<':
    if x > y:
      return False
  if op == '>':
    if x < y:
      return False
  return True

def go(idx, num):
  if idx == n+1:
    ans.append(num)
    return
  for i in range(10):
    if check[i]:
      continue
    if idx == 0 or good(num[idx-1], str(i), a[idx-1]):
      check[i] = True
      go(idx+1, num+str(i))
      check[i] = False
      
n = int(input())
a = input().split()
ans = []
check = [False] * 10
go(0, '')
ans.sort()
print(ans[-1])
print(ans[0])