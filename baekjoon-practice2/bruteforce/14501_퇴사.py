# Input
N = int(input())
T = [0] * (N+1)
P = [0] * (N+1)
result = 0
for i in range(1, N+1):
  T[i], P[i] = map(int, input().split())
  

# Brute-Force
def solve(day, pay):
  global result
  if day == N+1:
    result = max(result, pay)
    return
  if day > N:
    return
  
  solve(day+1, pay)
  solve(day+T[day], pay+P[day])

# Main
solve(1, 0)
print(result)