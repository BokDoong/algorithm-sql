import sys
input = sys.stdin.readline

# DP
DP = [0]*101
buffer = 0
for i in range(101):
  DP[i]=i

# 계산
for i in range(7,101):
  DP[i] = max(DP[i-3]*2, DP[i-4]*3, DP[i-5]*4)
    
# 결과
print(DP[int(input().rstrip())])