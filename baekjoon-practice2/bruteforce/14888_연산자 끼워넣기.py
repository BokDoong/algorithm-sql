import sys
input = sys.stdin.readline

# 탐색
def calculate(plus, minus, multi, div, depth, result):
  global N, nums, maxResult, minResult
  
  if depth == N-1:
    maxResult = max(maxResult, result)
    minResult = min(minResult, result)
    return
  
  if plus > 0:
    calculate(plus-1, minus, multi, div, depth+1, result+nums[depth+1])
  if minus > 0:
    calculate(plus, minus-1, multi, div, depth+1, result-nums[depth+1])
  if multi > 0:
    calculate(plus, minus, multi-1, div, depth+1, result*nums[depth+1])
  if div > 0:
    if result < 0:
      calculate(plus, minus, multi, div-1, depth+1, -(abs(result)//nums[depth+1]))
    else:
      calculate(plus, minus, multi, div-1, depth+1, result//nums[depth+1])

# Input
N = int(input())
nums = list(map(int, input().split()))
plus, minus, multi, div = map(int, input().split())

# Main
maxResult, minResult = -sys.maxsize, sys.maxsize
calculate(plus, minus, multi, div, 0, nums[0])
print(maxResult)
print(minResult)
