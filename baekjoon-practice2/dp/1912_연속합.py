# Input
n = int(input())
nums = list(map(int, input().split()))

# Main
result = []
result.append(nums[0])

for i in range(1, n):
  result.append(max(result[i-1]+nums[i], nums[i]))

# Output
print(max(result))