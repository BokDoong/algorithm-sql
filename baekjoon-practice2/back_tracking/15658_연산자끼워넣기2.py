import sys
input = sys.stdin.readline


N = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))
MAX = -sys.maxsize
MIN = sys.maxsize

def solve(val, depth, add, minus, multi, div):
  global MAX, MIN
  
  if depth == N:
    MAX = max(MAX, val)
    MIN = min(MIN, val)
    return
  
  if add > 0:
    solve(val+nums[depth], depth+1, add-1, minus, multi, div)
  if minus > 0:
    solve(val-nums[depth], depth+1, add, minus-1, multi, div)
  if multi > 0:
    solve(val*nums[depth], depth+1, add, minus, multi-1, div)
  if div > 0:
    solve(int(val/nums[depth]), depth+1, add, minus, multi, div-1)
    
  
solve(nums[0], 1, ops[0], ops[1], ops[2], ops[3])
print(MAX)
print(MIN)