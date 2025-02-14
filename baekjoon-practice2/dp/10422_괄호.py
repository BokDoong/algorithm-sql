import sys
input = sys.stdin.readline

# 괄호 개수 담을 문자열
DP = [0]*5001
DP[0] = 1
for i in range(2, 5001, 2):
  for j in range(2, i+1, 2):
    DP[i] += (DP[j-2]*DP[i-j]) % 1000000007
    
# 테스트
T = int(input().rstrip())
for _ in range(T):
  t = int(input().rstrip())
  print(DP[t] % 1000000007)