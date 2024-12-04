# Input
N = int(input())

# Main
dp = [0] * 31
dp[2] = 3
for i in range(4, 31, 2):
  # 직전꺼에서 3개 붙여짐
  dp[i] += dp[i-2] * 3
  # 각각의 경우에서 현재 타일 개수에서 나오는 고유 형태
  dp[i] += sum(dp[:i-3]) * 2
  # 2개의 고유 형태
  dp[i] += 2
  
# Output
print(dp[N])