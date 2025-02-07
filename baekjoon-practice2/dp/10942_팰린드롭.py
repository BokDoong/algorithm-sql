import sys
input = sys.stdin.readline

# 자연수 N개
N = int(input().rstrip())
# 자연수 
nums = list(map(int, input().split()))

# DP
dp = [[0]*N for _ in range(N)]
for now in range(N):
  dp[now][now] = 1  # 자기자신부터 자기자신까지는 1
  for start in range(now-1):
    if nums[start] != nums[now]:    # 처음이랑 끝이 같아야함
      continue
    if dp[start+1][now-1] == 0:    # 사이에 있는 애들이 같아야함
      continue
    dp[start][now] = 1
  if nums[now] == nums[now-1]:    # 직전수는 따로 빼서 같으면 1
    dp[now-1][now]=1
  
# 결과
result = []
# 질문 M개
M = int(input().rstrip())
# 질문
for _ in range(M):
  start, end = map(int, input().split())
  print(dp[start-1][end-1])