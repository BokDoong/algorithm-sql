import copy

# 바꾸기
def horizontal_switch(candies, x, y):
  candy1 = candies[x][y]
  candy2 = candies[x][y+1]
  candies[x][y] = candy2
  candies[x][y+1] = candy1
  return candies
  
def vertical_switch(candies, x, y):
  candy1 = candies[x][y]
  candy2 = candies[x+1][y]
  candies[x][y] = candy2
  candies[x+1][y] = candy1
  return candies

# 가장 긴 연속 사탕 행/열 찾기
def find_max(candies, size):
  result = 0
  
  # 가로
  for i in range(size):
    tmp = 1
    for j in range(size-1):
      if candies[i][j] == candies[i][j+1]:
        tmp+=1
        result = max(result, tmp)
      else:
        tmp = 1
    
  # 세로
  for i in range(size):
    tmp = 1
    for j in range(size-1):
      if candies[j][i] == candies[j+1][i]:
        tmp+=1
        result = max(result, tmp)
      else:
        tmp = 1
        
  return result

# Main
max_value = 0
size = int(input())
candies = []
for _ in range(size):
  candies.append(list(input()))

for i in range(size):
  for j in range(size-1):
    horizontal_switched_candies = horizontal_switch(copy.deepcopy(candies), i, j)
    vertical_switched_candies = vertical_switch(copy.deepcopy(candies), j, i)
    max_value = max(max_value, find_max(horizontal_switched_candies, size), find_max(vertical_switched_candies, size))

print(max_value)