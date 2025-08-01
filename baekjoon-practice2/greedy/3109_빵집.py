from collections import deque
import sys
input = sys.stdin.readline

# 갈 수 있는지 체크
def canGo(r, c):
  global R, C
  if 0 <= r < R and 0 <= c < C:
    return True
  return False

# 이동
def move(nowR, nowC):
  global R, C, pipelines, answer, dr, dc, finished
  
  # 끝 
  if nowC == C-1:
    finished = True
    answer += 1
    return
  
  # 탐색
  for i in range(3):
    nextR, nextC = nowR + dr[i], nowC + dc[i]
    if canGo(nextR, nextC) and pipelines[nextR][nextC] == '.':
      if finished:
        continue
      pipelines[nextR][nextC] = 1
      move(nextR, nextC)

# 입력
R, C = map(int, input().split())
pipelines = []
for _ in range(R):
  pipelines.append(list(input().rstrip()))
  
  
# 필요한 변수
answer = 0
dr, dc = [-1, 0, 1], [1, 1, 1]
finished = False

# 이동
for r in range(R):
  startR, startC = r, 0
  pipelines[startR][startC] = 1
  finished = False
  move(startR, startC)
  
print(answer)