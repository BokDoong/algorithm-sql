import sys
input = sys.stdin.readline

# 문자
first = '0'+input().rstrip()
second = '0'+input().rstrip()
# 크기
firstSize = len(first)
secondSize = len(second)

# DP
DP = [[(0,'')]*(firstSize) for _ in range(secondSize)]
for i in range(1, secondSize):
  for j in range(1, firstSize):
    DP[i][j] = DP[i][j-1]
    if DP[i][j][0] < DP[i-1][j][0]:
      DP[i][j] = DP[i-1][j]
    if second[i] == first[j]:
      DP[i][j] = (DP[i-1][j-1][0]+1, DP[i-1][j-1][1]+second[i])

if DP[secondSize-1][firstSize-1][0] == 0:
  print(0)
else:
  print(DP[secondSize-1][firstSize-1][0])
  print(DP[secondSize-1][firstSize-1][1])