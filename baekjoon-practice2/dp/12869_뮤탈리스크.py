import sys
input = sys.stdin.readline

n = int(input())
scv = list(map(int, input().split()))
scv.extend([0,0])     # 3개 미만인 경우 대비

# DP의 각 컬럼은 SCV의 체력
# 안에 값은 해당 체력이 되기 위한 최소 공격 횟수
dp = [[[0]*61 for _ in range(61)] for _ in range(61)]
dp[scv[0]][scv[1]][scv[2]] = 1      # 시작 체력 초기화

comb = [(9,3,1), (9,1,3), (3,9,1), (3,1,9), (1,9,3), (1,3,9)]
for i in range(60,-1,-1):
  for j in range(60,-1,-1):
    for k in range(60,-1,-1):
      if dp[i][j][k] > 0:
        for c in comb:
          nextI = i-c[0]
          if nextI < 0:   # 부서짐
            nextI = 0
          nextJ = j-c[1]
          if nextJ < 0:
            nextJ = 0
          nextK = k-c[2]
          if nextK < 0:
            nextK = 0
          # 처음 도착하거나 더 적은 횟수로 도착하는 경우 업데이트
          if dp[nextI][nextJ][nextK] == 0 or dp[nextI][nextJ][nextK] > dp[i][j][k]+1:
            dp[nextI][nextJ][nextK] = dp[i][j][k]+1
print(dp[0][0][0]-1)