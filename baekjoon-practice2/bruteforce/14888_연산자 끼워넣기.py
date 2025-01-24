import sys
input = sys.stdin.readline


# Methods
def caculate(com):
  global nums, N, commands
  
  result = nums[0]
  for i in range(N-1):
    opt = commands[com[i]]
    if opt == '+':
      result = result + nums[i+1]
    elif opt == '-':
      result = result - nums[i+1]
    elif opt == '*':
      result = result * nums[i+1]
    elif opt == '/':
      if result < 0:
        result = ((result*(-1))//nums[i+1]) * -1
      else:
        result = result // nums[i+1]
  
  return result

def solve(depth, com):
  global max_num, min_num
  
  if depth == N-1:
    now = caculate(com)
    max_num = max(max_num, now)
    min_num = min(min_num, now)
    return
  
  for i in range(N-1):
    if i in com:
      continue
    
    com.append(i)
    solve(depth+1, com)
    com.pop()


# Input
# 숫자 개수, 숫자들
N = int(input())
nums = list(map(int, input().split()))

# 연산자 구성
commands = []
tmp_commands = ['+', '-', '*', '/']
tmp = list(map(int, input().split()))    # +, -, *, /
for t in range(4):
  for _ in range(tmp[t]):  
    commands.append(tmp_commands[t])


# Main
max_num = -1000000001
min_num = 1000000001
solve(0, [])


# Output
print(max_num)
print(min_num)