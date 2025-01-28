import sys
input = sys.stdin.readline


# Methods
def solve(value, depth, add, minus, multi, div):
  global max_num, min_num
  
  if depth == N:
    max_num = max(max_num, value)
    min_num = min(min_num, value)
    return
  
  if add > 0:
    solve(value+nums[depth], depth+1, add-1, minus, multi, div)
  if minus > 0:
    solve(value-nums[depth], depth+1, add, minus-1, multi, div)
  if multi > 0:
    solve(value*nums[depth], depth+1, add, minus, multi-1, div)
  if div > 0:
    solve(int(value/nums[depth]), depth+1, add, minus, multi, div-1)


# Input
N = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))


# Main
max_num = -1000000001
min_num = 1000000001
solve(nums[0], 1, ops[0], ops[1], ops[2], ops[3])


# Output
print(max_num)
print(min_num)