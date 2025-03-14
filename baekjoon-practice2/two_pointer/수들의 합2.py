import sys 
input = sys.stdin.readline

# N, M, 숫자들
N, M = map(int, input().split())
nums = list(map(int, input().split()))

# 투포인터
result = 0
left, right = 0, 1
while left <= right <= N:
  total = sum(nums[left:right])
  if total < M:
    right+=1
  elif total > M:
    left+=1
  else:
    result+=1
    right+=1
    
print(result)