# Input
l, c = map(int, input().split())
alphabets = list(input().split())
alphabets.sort()
result = []
visited = [False]*c


# Check
def possible():
  global result
  mo = 0
  for r in result:
    if r in ['a', 'e', 'i', 'o', 'u']:
      mo += 1
  ja = len(result) - mo
  
  if mo >= 1 and ja >= 2:
    return True
  else:
    return False


# Brute-Force
def solve(idx):
  global result
  if len(result) == l:
    if possible():
      for r in result:
        print(r, end='')
      print()
    return
  
  for i in range(idx, c):
    if visited[i]:
      continue
    
    visited[i] = True
    result.append(alphabets[i])
    solve(i+1)
    result.pop()
    visited[i] = False
    

# Main
solve(0)