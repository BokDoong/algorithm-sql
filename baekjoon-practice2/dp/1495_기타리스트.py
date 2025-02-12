import sys
input = sys.stdin.readline

# 곡의 개수 N, 시작 볼륨 S, 최대 볼륨 M
N, S, M = map(int, input().split())
# 볼륨
volumes = [0] + list(map(int, input().split()))

# DP, 시작 볼륨 초기화
DP = [[False]*(M+1) for _ in range(N+1)]
DP[0][S] = True

# 하나씩 DP 시작
for i in range(1, N+1):
  for j in range(M+1):
    if DP[i-1][j]:            # 이전 볼륨
      plusVolume = j+volumes[i]    # 볼륨 높였을 때 
      if plusVolume <= M:
        DP[i][plusVolume] = True
      minusVolume = j-volumes[i]    # 볼륨 낮췄을때
      if minusVolume >= 0:
        DP[i][minusVolume] = True
  
# Output
result = -1
for i in range(M, -1, -1):
  if DP[N][i]:
    result = i
    break
print(result)