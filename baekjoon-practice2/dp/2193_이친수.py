# Main
result = [[0] * 2 for _ in range(90)]
result[0][1] = 1
result[1][0] = 1

for i in range(2, 90):
  result[i][0] = result[i-1][0]+result[i-1][1]
  result[i][1] = result[i-1][0]
  
# Input & Output
n = int(input())
print(sum(result[n-1]))