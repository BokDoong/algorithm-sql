import sys
input = sys.stdin.readline

# 입력
firstWord = input().rstrip()
secondWord = input().rstrip()

# DP
DP = [[0]*(len(firstWord)+1) for _ in range(len(secondWord)+1)]
for i in range(1, len(secondWord)+1):
  for j in range(1, len(firstWord)+1):
    if secondWord[i-1] == firstWord[j-1]:
      DP[i][j] = DP[i-1][j-1] + 1
    else:
      DP[i][j] = max(DP[i-1][j], DP[i][j-1])

# 결과
print(DP[len(secondWord)][len(firstWord)])
