import sys
input = sys.stdin.readline


# Methods
def caculate_sum(targets):
  global nums
  
  # # 길이가 0
  # if len(targets) == 0:
  #   return -1
  
  # 합 계산
  answer = 0
  for t in targets:
    answer += nums[t]
  return answer

# targets 안에는 인덱스 넣기
def solve(start, targets):
  global N, S, result
  
  if len(targets) > 0 and caculate_sum(targets) == S:
    result += 1
  
  for i in range(start, N):
    if i in targets:
      continue
    
    targets.append(i)
    solve(i, targets)
    targets.pop()
    

# Input
N, S = map(int, input().split())
nums = list(map(int, input().split()))
result = 0


# Main
solve(0, [])
print(result)