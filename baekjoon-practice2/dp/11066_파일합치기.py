import sys
input = sys.stdin.readline

def solve():
  N = int(input().rstrip())
  files = [0] + list(map(int, input().split()))   # 파일
  
  sums = [0]*(N+1)      
  for s in range(1, N+1):
    sums[s] = sums[s-1]+files[s]    # 누적합
    
  # dp[i][j] = i~j까지 합하는 데 필요한 최소 비용
  dp = [[0] * (N+1) for _ in range(N+1)]
  for i in range(2, N+1):   # 파일 길이
    for j in range(1, N-i+2):
      tmp = sys.maxsize
      for k in range(i-1):
        tmp = min(tmp, dp[j][j+k]+dp[j+k+1][j+i-1])   # 점화식 
      dp[j][j+i-1] = tmp + sums[i+j-1] - sums[j-1]    # 누적합 더하기
  
  # 출력
  print(dp[1][N])
  
for _ in range(int(input())):
  solve()