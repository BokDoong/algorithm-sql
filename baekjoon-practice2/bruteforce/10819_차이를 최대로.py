# Input
n = int(input())
nums = list(map(int, input().split()))
swap_idx = 0
max_num = 0

# Permutation Methods
def swap(idx):
  global nums, swap_idx
  tmp = nums[swap_idx]
  nums[swap_idx] = nums[idx]
  nums[idx] = tmp
  
def sort_nums():
  global nums, swap_idx
  tmp_nums = nums[swap_idx+1:]
  tmp_nums.sort()
  nums[swap_idx+1:] = tmp_nums
  
def find_and_swap_nums():
  global nums, n
  for i in range(n-1, 0, -1):
    if nums[swap_idx] < nums[i]:
      swap(i)
      sort_nums()
      return
  
def swap_possible():
  global n, nums, swap_idx
  for i in range(n-1, 0, -1):
    if nums[i] > nums[i-1]:
      swap_idx = i-1
      return True
  return False

def calculate_max_num():
  global max_num, nums, n
  tmp = 0
  for i in range(n-1):
    tmp += abs(nums[i] - nums[i+1])
  max_num = max(max_num, tmp)
    
def solve():
  nums.sort()
  while swap_possible():
    find_and_swap_nums()
    calculate_max_num()
  print(max_num)
  return
    
# Main
solve()