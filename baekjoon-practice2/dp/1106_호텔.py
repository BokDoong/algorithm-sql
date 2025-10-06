import sys
input = sys.stdin.readline

C, N = map(int, input().split())
costs = [list(map(int,input().split())) for _ in range(N)]

DP = [sys.maxsize for _ in range(C+100)]
DP[0] = 0

for cost, numPeople in costs:
  for i in range(numPeople, C+100):
    DP[i] = min(DP[i - numPeople] + cost, DP[i])
    
print(min(DP[C:]))