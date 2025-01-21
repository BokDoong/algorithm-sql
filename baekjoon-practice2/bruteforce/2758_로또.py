import sys
input = sys.stdin.readline


# Methods
def solve(k, nums, visited, idx, results, start):
  if idx == 6:
    print(' '.join(results))
    return
  
  for i in range(start, k):
    if visited[i]:
      continue
    
    visited[i] = True
    results.append(str(nums[i]))
    solve(k, nums, visited, idx+1, results, i)
    results.pop()
    visited[i] = False
    

# Main
while True:
  inputs = list(map(int,input().split()))

  # 0이면 끝
  if len(inputs) == 1 and inputs[0] == 0:
    break

  # k, S
  k = inputs[0]
  nums = inputs[1:]

  # 탐색
  visited = [False] * k
  solve(k, nums, visited, 0, [], 0)
  print()
