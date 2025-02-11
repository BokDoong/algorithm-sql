import sys
input = sys.stdin.readline


# 물품 N개, 버틸 무게 K
N, K = map(int, input().split())

# DP 표 - x좌표 : 보석을 하나씩 넣을때, y좌표 : 무게
# DP[x][y] - x번째 보석을 넣었을 때 y만큼만 무게를 들 수 있는 경우 최대 가치
DP = [[0]*(K+1) for _ in range(N+1)]
for i in range(1, N+1):
  w, v = map(int, input().split())    # 보석의 무게, 가치
  
  for j in range(K+1):
    if j >= w:      # w이상인 무게 애들만 비교   
      DP[i][j] = max(DP[i-1][j], DP[i-1][j-w]+v)
    else:           # 아닌애들은 유지
      DP[i][j] = DP[i-1][j]
  
# 결과
print(DP[N][K])