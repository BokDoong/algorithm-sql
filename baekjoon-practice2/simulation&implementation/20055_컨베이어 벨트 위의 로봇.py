from collections import deque
import sys
input = sys.stdin.readline


# Methods
# 로봇 움직이기
def move_robot():
  global robots, N
  cnt = len(robots)
  while cnt > 0:
    robots.append(robots.popleft()+1)
    cnt-=1

# Input
N, K = map(int, input().split())
belts = deque(list(map(int, input().split())))


# Main
robots = deque([])    # 로봇의 인덱스 위치를 저장
result = 1

while True:
  # 1 : 회전
  belts.appendleft(belts.pop())
  move_robot()
  if N-1 in robots:
    robots.remove(N-1)

  # 2 : 로봇 하나씩 이동
  for i in range(len(robots)):
    # 이동할 칸
    next = robots[i]+1
    # 이동할 칸에 로봇있는지 + 내구도 검사
    if next not in robots and belts[next] > 0:    
      robots[i] = next
      belts[next] -= 1
      
  # 내리는 위치 로봇
  if N-1 in robots:
    robots.remove(N-1)
      
  # 3 : 로봇 올리기
  if belts[0] > 0:
    robots.append(0)
    belts[0] -= 1
    
  # 4 : 내구도 0 검사
  if belts.count(0) >= K:
    break

  # 단계 추가
  result += 1
  
  
# Output
print(result)