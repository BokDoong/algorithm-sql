# Input
n = int(input())
result = [[0]*10 for _ in range(n)]
result[0][0] = 0
for i in range(1, 10):
  result[0][i] = 1

# Main
for p in range(1, n):
  result[p][0] = (result[p-1][1])%1000000000
  result[p][9] = (result[p-1][8])%1000000000
  for i in range(1, 9):
    result[p][i] = result[p-1][i-1]%1000000000+result[p-1][i+1]%1000000000

# Output
print(sum(result[n-1])%1000000000)