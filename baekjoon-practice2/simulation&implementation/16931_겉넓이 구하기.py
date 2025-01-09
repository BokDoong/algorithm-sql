import sys
input = sys.stdin.readline  
  
# Methods
def calculate(nums):
  size = len(nums)
  result = 0 
  
  for i in range(size):
    if i == 0:
      result += nums[i]
    else:
      if nums[i] > nums[i-1]:
        result += (nums[i]-nums[i-1])
  
  return result

def up_down():
  global N, M
  
  return N*M*2


# Input
N, M = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(map(int, input().split())))


# Main
extent = 0

# 위/아래
extent += up_down() 
# 옆
for i in range(N):
  extent += calculate(board[i])*2
# 앞/뒤
for i in range(M):
  tmp = []
  for j in range(N):
    tmp.append(board[j][i])
  extent += calculate(tmp)*2


# Output
print(extent)