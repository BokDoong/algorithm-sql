# Main
def check():
  global n, nums, norm_idx
  for i in range(n-1, 0, -1):
    if nums[i] > nums[i-1]:
      norm_idx = i-1
      return True
  return False
  
def find_swap_num():
  global n, nums, norm_idx
  for i in range(n-1, 0, -1):
    if nums[i] > nums[norm_idx]:
      return i

def swap(target_idx):
  global nums, norm_idx
  tmp = nums[norm_idx]
  nums[norm_idx] = nums[target_idx]
  nums[target_idx] = tmp
  
def sort_nums():
  global nums, norm_idx
  tmp_nums = nums[norm_idx+1:]
  tmp_nums.sort()
  nums[norm_idx+1:] = tmp_nums
    
# Input
n = int(input())
nums = []
for i in range(1, n+1):
  nums.append(i)
norm_idx = 0    
    
# Output
for i in nums:
  print(i, end=' ')
print()
while check():
  swap_idx = find_swap_num()
  swap(swap_idx)
  sort_nums()
  for i in nums:
    print(i, end=' ')
  print()