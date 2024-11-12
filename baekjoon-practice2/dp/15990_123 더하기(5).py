# Input
result = [[0] * 4 for _ in range(100001)]
result[1][1] = 1
result[2][2] = 1
result[3][1] = 1; result[3][2] = 1; result[3][3] = 1

# Main
for i in range(4, 100001):
  result[i][1] = (result[i-1][2]+result[i-1][3])%1000000009
  result[i][2] = (result[i-2][1]+result[i-2][3])%1000000009
  result[i][3] = (result[i-3][1]+result[i-3][2])%1000000009
  
# Output
t = int(input())
for _ in range(t):
  n = int(input())
  print((result[n][1]+result[n][2]+result[n][3])%1000000009)