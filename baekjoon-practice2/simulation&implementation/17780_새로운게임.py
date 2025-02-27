from collections import deque
import heapq
import sys
input = sys.stdin.readline

# 이동 말 정보 최신화
def renew(curX, curY, nextX, nextY, candidates, turn):
  global horses
  curHorses = horses[(curX, curY)]    # 이동하려는 말과 같은 칸에있는 애들
  curHorseNum = curHorses[0][0]       # 원래 가장 아래에 있던 말 번호
  
  # 빨간칸이면 반대로
  color = board[nextX][nextY]
  if color == 1:
    curHorses.reverse()
  # 이동칸에 먼저 있으면 추가, 아니면 새로하고 맨밑에 말 검사
  if (nextX,nextY) in horses:   
    horses[(nextX,nextY)].extend(curHorses)
    if len(horses[(nextX,nextY)]) >= 4:
      print(turn)
      exit()
  else:
    horses[(nextX,nextY)] = curHorses
    if color == 1 and curHorses[0][0] > curHorseNum:
      heapq.heappush(candidates, (curHorses[0][0], curHorses[0][1], nextX, nextY))
  # 이전 말들은 삭제
  del horses[(curX, curY)]
  

# 이동 - 이동방향 : 우(1), 좌(2), 상(3), 하(4)
def move(vector, x, y):
  if vector == 1:
    return x, y+1
  elif vector == 2:
    return x, y-1
  elif vector == 3:
    return x-1, y
  else:
    return x+1, y
  
# 방향 반대로
def reverseVector(vector):
  if vector == 1:
    return 2
  elif vector == 2:
    return 1
  elif vector == 3:
    return 4
  else:
    return 3
  
# 다음 좌표 파랗거나, 벗어나는지 확인
def checkNextBlueOrOut(nextX, nextY):
  if nextX < 0 or nextY < 0 or nextX >= N or nextY >= N or board[nextX][nextY] == 2:
    return True
  return False

# 체크판 크기 : N, 말의 개수 : K
N, K = map(int, input().split())
# 체스판
board = []
for _ in range(N):
  board.append(list(map(int, input().split())))
# 말 정보 : {(x,y):덱 - [(말 번호, 말의 이동방향)]} & 이동방향 : 우(1), 좌(2), 상(3), 하(4)
horses = {}
for k in range(1,K+1):
  x, y, vector = map(int,input().split())
  horses[(x-1,y-1)] = deque([(k, vector)])

# 턴 이동
turn = 1
while turn < 1001:
  # 이동할 말 뽑아서 최소힙에 저장 - (말번호, 이동방향, 좌표)
  candidates = []
  for x, y in horses:
    num, vector = horses[(x,y)][0]
    heapq.heappush(candidates, (num, vector, x, y))
    
  # 이동
  while candidates:
    num, vector, x, y = heapq.heappop(candidates)   # 말 번호, 이동방향, 좌표
    nextX, nextY = move(vector, x, y)      # 다음 좌표
    
    # 파란색칸, 벗어남
    if checkNextBlueOrOut(nextX,nextY):
      # 방향 반대로
      vector = reverseVector(vector)
      horses[(x,y)].popleft()
      horses[(x,y)].appendleft((num, vector))
      # 다시 다음 좌표 계산
      nextX, nextY = move(vector, x, y)      # 다음 좌표
      if not checkNextBlueOrOut(nextX,nextY):
        renew(x,y,nextX,nextY,candidates,turn)
    else:
      renew(x,y,nextX,nextY,candidates,turn)
  
  # 다음 턴
  turn += 1
  
# 끝
print(-1)