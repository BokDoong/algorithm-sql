# Input
n = int(input())
nums = list(map(int, input().split()))
stack = [0]
cnt_dict = {}
result = [-1] * n

# 횟수 카운트
for num in nums:
  if num in cnt_dict:
    cnt_dict[num] += 1
  else:
    cnt_dict[num] = 1
    
# Main
for i in range(1, n):
  while stack and cnt_dict[nums[stack[-1]]] < cnt_dict[nums[i]]:
    result[stack.pop()] = nums[i]
  stack.append(i)

# Output
print(*result)