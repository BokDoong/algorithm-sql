import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

DP = [[0]*N for _ in range(21)]
DP[nums[0]][0] = 1

for i in range(1, N-1):
  num = nums[i]
  for n in range(0, 21):
    if DP[n][i-1] > 0:
      if 0 <= n + num <= 20:
        DP[n + num][i] += DP[n][i-1]
      if 0 <= n - num <= 20:
        DP[n - num][i] += DP[n][i-1]
        
print(DP[nums[-1]][N-2])
