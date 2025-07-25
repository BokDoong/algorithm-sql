import sys
input = sys.stdin.readline

# 입력
N = int(input())
nums = []
for _ in range(N):
  nums.append(int(input()))
  
# 탐색 : < 이면 제거, < 이면 +(배열 길이)
remains = [nums[0]]
result, remainsLen = 0, 1
for i in range(1, N):
  next = nums[i]
  while True:
    if remains and remains[-1] <= next:
      remains.pop()
      remainsLen -= 1
    else:
      result += remainsLen
      remains.append(next)
      remainsLen += 1
      break
    
print(result)