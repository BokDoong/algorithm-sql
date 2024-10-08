# 타겟 넘버
target = int(input())
if target == 100:
  print(0)
  exit()

# 부서진 버튼 개수
n = int(input())
if n == 0:
  print(len(str(target)))
  exit()
if n == 10:
  print(abs(target - 100))
  exit()
  
# 부서진 버튼 제거
buttons = [True] * 10
broken_buttons = list(map(int, input().split()))
for btn in broken_buttons:
  buttons[btn] = False
  
# 검사
def can_make(num):
  if num == 0:
    if buttons[0] == True:
      return 1
    else:
      return 0
  
  tmp = str(num)
  for i in range(len(tmp)):
    if buttons[int(tmp[i])] == False:
      return 0
  return len(tmp)

# Main 
result = abs(target - 100)
for i in range(0, 1000001):
  move = can_make(i)
  if move > 0:
    press = abs(i - target)
    if result > press + move:
      result = press + move
      
print(result)