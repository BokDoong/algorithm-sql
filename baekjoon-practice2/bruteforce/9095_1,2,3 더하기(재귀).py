# Brute-Force
result = [0] * 11
def solve(total):
  if total > 10:
    return
  else:
    result[total] += 1
    
  for n in range(1,4):
    solve(total+n)
  

# Main
n = int(input())
solve(0)
for _ in range(n):
  t  = int(input())
  print(result[t])