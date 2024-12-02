# Input
N = int(input())
nums = list(map(int, input().split()))

# Main
# 1. 정방향 증가하는 부분수열
dp1 = [1] * N
for i in range(N):
  for j in range(i):
    if nums[j] < nums[i]:
      dp1[i] = max(dp1[j]+1, dp1[i])

# 2. 역방향 증가하는 부분수열
nums.reverse()
dp2 = [1] * N
for i in range(N):
  for j in range(i):
    if nums[j] < nums[i]:
      dp2[i] = max(dp2[j]+1, dp2[i])
dp2.reverse()

# 3. 최대값 찾기
result = 0
for i in range(N):
  result = max(result, dp1[i]+dp2[i])

# Output
print(result-1)