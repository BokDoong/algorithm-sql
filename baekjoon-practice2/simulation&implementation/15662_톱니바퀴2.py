from collections import deque
import sys
input = sys.stdin.readline  
  
# Methods
# 톱니바퀴 회전 - num : 톱니바퀴 번호, dir : 회전 방향
def rotate(num, dir):
  global wheels
  
  # 시계 방향(dir : 1)
  if dir == 1:
    wheels[num].appendleft(wheels[num].pop())
  # 반시계 방향(dir : -1)
  elif dir == -1:
    wheels[num].append(wheels[num].popleft())
    
  return
    
# 12시 방향 S극인 톱니바퀴 찾기
def find_result():
  global wheels
  
  result = 0
  for i in range(1, T+1):
    if wheels[i].popleft() == '1':
      result += 1
      
  return result
  

# Input
T = int(input())
wheels = [0]
for _ in range(T):
  tmp = deque(list(input()))
  tmp.pop()
  wheels.append(tmp)


# Main
K = int(input())
for _ in range(K):
  wheel_num, dir = map(int, input().split())
  
  rotated = [False for _ in range(T+1)]
  queue = deque([(wheel_num, dir)])
  while(queue):
    num, dir = queue.popleft()
    
    # 처음일 경우 오른쪽에 있는 애만 확인
    if num == 1 and T > 1 and not rotated[num+1]:
      if wheels[num][2] != wheels[num+1][6]:
        queue.append((num+1, -1*dir))
    # 마지막일 경우 왼쪽에 있는 애만 확인
    if num == T and T > 1 and not rotated[num-1]:
      if wheels[num][6] != wheels[num-1][2]:
        queue.append((num-1, -1*dir))
    # 주변 톱니바퀴 확인
    if 1 < num < T:
      if wheels[num][2] != wheels[num+1][6] and not rotated[num+1]:
        queue.append((num+1, -1*dir))
      if wheels[num][6] != wheels[num-1][2] and not rotated[num-1]:
        queue.append((num-1, -1*dir))
    
    # 회전
    rotated[num] = True
    rotate(num, dir)


# Output
print(find_result())