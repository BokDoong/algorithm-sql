# Input
n = int(input())
nums = list(map(int, input().split()))
result = [1]*n

# Main
for i in range(1, n):
  for j in range(i):
    if nums[i] > nums[j]:
      result[i] = max(result[i], result[j]+1)

# Output(1) - Max Length
max_cnt = max(result)
idx = result.index(max_cnt)
print(max_cnt)

# Output(2) - Nums
stack = []
for i in range(n-1, -1, -1):
  if result[i] == max_cnt:
    stack.append(nums[i])
    max_cnt -= 1

stack.reverse()
print(*stack)