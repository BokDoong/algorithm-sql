import sys
input = sys.stdin.readline

# 백트래킹
def backTracking(value, depth, add, minus, gob, div):
  global minValue, maxValue
  
  # 끝
  if depth == N:
    minValue = min(value, minValue)
    maxValue = max(value, maxValue)
    return
  # 탐색  
  if add > 0:
    backTracking(value+nums[depth], depth+1, add-1, minus, gob, div)
  if minus > 0:
    backTracking(value-nums[depth], depth+1, add, minus-1, gob, div)
  if gob > 0:
    backTracking(value*nums[depth], depth+1, add, minus, gob-1, div)
  if div > 0:
    backTracking(int(value/nums[depth]), depth+1, add, minus, gob, div-1)

# 수의 개수
N = int(input().rstrip())
# 수
nums = list(map(int,input().split()))
# 연산자 : +, -, * /
op = list(map(int, input().split()))

# 연산
minValue = 1000000001
maxValue = -1000000001
backTracking(nums[0], 1, op[0], op[1], op[2], op[3])

# 결과
print(maxValue)
print(minValue)
