import sys
input = sys.stdin.readline

# Main
N = int(input())
DP = [1]*N
lines = []
for _ in range(N):
  start, end = map(int, input().split())
  lines.append([start, end])
  
lines.sort()

for i in range(1, N):
  for j in range(0, i):
    if lines[j][1] < lines[i][1]:
      DP[i] = max(DP[i], DP[j]+1)

print(N-max(DP))
