import sys
input = sys.stdin.readline

def histogram(nums):
  stack = []
  nums.append(0)
  result = 0
  
  for now in range(len(nums)):
    value = nums[now]
    start = now
    while stack and stack[-1][1] >= value:
      idx, height = stack.pop()
      result = max(result, (now-idx)*height)
      start = idx
    stack.append((start, value))
  
  print(result)
  
while True:
  tmps = list(map(int, input().split()))
  if tmps[0] == 0:
    break
  else:
    histogram(tmps[1:])