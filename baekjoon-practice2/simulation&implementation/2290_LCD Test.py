import sys
input = sys.stdin.readline

# 1~9 각 수 마다 함수 생성
def display(num, startX, startY):
  global s, result
  
  # 상단 --
  if num in ['2', '3', '5', '6', '7', '8', '9', '0']:
    for i in range(1, s+1):
      result[startX][startY+i] = '-'
  # 좌측 상단 |
  if num in ['4', '5', '6', '8', '9', '0']:
    for i in range(1, s+1):
      result[startX+i][startY] = '|'
  # 우측 상단 |
  if num in ['1', '2', '3', '4', '7', '8', '9', '0']:
    for i in range(1, s+1):
      result[startX+i][startY+s+1] = '|'
  # 가운데 --
  if num in ['2','3','4','5','6','8','9']:
    for i in range(1, s+1):
      result[startX+s+1][startY+i] = '-'
  # 좌측 하단 |
  if num in ['2', '6', '8', '0']:
    for i in range(1, s+1):
      result[startX+s+1+i][startY] = '|'
  # 우측 하단 |
  if num in ['1', '3', '4', '5', '6', '7', '8', '9', '0']:
    for i in range(1, s+1):
      result[startX+s+1+i][startY+s+1] = '|'
  # 하단 --
  if num in ['2','3','5','6','8','9','0']:
    for i in range(1, s+1):
      result[startX+2*s+2][startY+i] = '-'



# Input
s, n = map(int, input().split())


# Main
size = len(str(n))
result = [[' ']*(size*(s+2)+(size-1)) for _ in range(2*s+3)]

x = 0
y = 0
for num in str(n):
  display(num, x, y)
  y += s+3


# Output
for i in range(len(result)):
  for j in range(len(result[0])):
    print(result[i][j], end='')
  print()