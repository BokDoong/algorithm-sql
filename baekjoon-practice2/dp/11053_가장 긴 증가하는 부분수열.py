# Input
n = int(input())
nums = list(map(int, input().split()))
result = [1] * n

# Main
for i in range(1, n):
  for j in range(i):
    if nums[j] < nums[i]:
      result[i] = max(result[i], result[j]+1)
    
# Output
print(max(result))