# DP
nums = [0]*12
nums[1] = 1
nums[2] = 2
nums[3] = 4

for i in range(4, 12):
  nums[i] = nums[i-1]+nums[i-2]+nums[i-3]

# Main
n = int(input())
for _ in range(n):
  target = int(input())
  print(nums[target])