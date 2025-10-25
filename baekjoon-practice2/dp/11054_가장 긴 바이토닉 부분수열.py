import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

DP1 = [1 for _ in range(N)]
for i in range(N):
  for j in range(i):
    if nums[j] < nums[i]:
      DP1[i] = max(DP1[j]+1, DP1[i])
      
nums.reverse()
DP2 = [1 for _ in range(N)]
for i in range(N):
  for j in range(i):
    if nums[j] < nums[i]:
      DP2[i] = max(DP2[j]+1, DP2[i])
DP2.reverse()
      
result = -sys.maxsize
for n in range(N):
  result = max(result, DP1[n]+DP2[n]-1)
  
print(result)
