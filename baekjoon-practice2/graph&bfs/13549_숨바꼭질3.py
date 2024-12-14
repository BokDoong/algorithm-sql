from collections import deque

# Input
N, K = map(int, input().split())

# Main
# 경로/깊이 저장 DP 배열
dp = [-1] * 100001
dp[N] = 0

# 탐색
queue = deque([N])
while queue:
  # 현재 위치, 깊이
  now = queue.popleft()
  depth = dp[now]
  
  # 이동(1) - 순간이동
  if now*2 < 100001 and dp[now*2] == -1:
    dp[now*2] = depth
    queue.appendleft(now*2)
    
  # 이동(2) - 앞/뒤 이동
  if now-1 >= 0 and dp[now-1] == -1:
    dp[now-1] = depth+1
    queue.append(now-1)
  if now+1 < 100001 and dp[now+1] == -1:
    dp[now+1] = depth+1
    queue.append(now+1)


# Output
print(dp[K])