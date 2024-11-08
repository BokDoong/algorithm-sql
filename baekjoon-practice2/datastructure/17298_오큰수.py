# Input
n = int(input())
nums = list(map(int, input().split()))
remains = [0]
result = [-1] * n

# Main
for i in range(1, n):
  while remains and nums[remains[-1]] < nums[i]:
    result[remains.pop()] = nums[i]
  remains.append(i)

# Output
for r in result:
  print(r, end=' ')