import sys
input = sys.stdin.readline

# Input
N, M, x, y, K = map(int, input().split())

# 지도
jido = []
for _ in range(N):
  jido.append(list(map(int, input().split())))
  
# 명령어(1:우, 2:좌, 3:상, 4:하)
commands = list(map(int, input().split()))

# 필요한 정보
dice = [0, 0, 0, 0, 0, 0]  # 주사위
dx = [0, 0, -1, 1] 
dy = [1, -1, 0, 0]  # 이동 벡터 좌표

# 이동 가능한지 체크
def can_move(nextX, nextY):
  if 0 <= nextX < N and 0 <= nextY < M:
    return True
  return False

# 지도, 주사위 정보 교환
def exchange_info():
  global jido, x, y, dice
  
  if jido[x][y] == 0:
    jido[x][y] = dice[5]
  else:
    dice[5] = jido[x][y]
    jido[x][y] = 0
    
# 굴리기
def roll(move):
  global dice
  
  if move == 1: # 동쪽으로 굴리면
    dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[3], dice[1], dice[0], dice[5], dice[4], dice[2] # 주사위 변화 4 2 1 6 5 3
  elif move == 2: # 서쪽으로 굴리면
    dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[2], dice[1], dice[5], dice[0], dice[4], dice[3] # 주사위 변화 3 2 6 1 5 4
  elif move == 3: # 북쪽으로 굴리면
    dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[4], dice[0], dice[2], dice[3], dice[5], dice[1] # 주사위 변화 5 1 3 4 6 2
  elif move == 4: # 남쪽으로 굴리면
    dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[1], dice[5], dice[2], dice[3], dice[0], dice[4] # 주사위 변화 2 6 3 4 1 5
    
# Main
for command in commands:
  # 이동 가능한지 체크
  if not can_move(x+dx[command-1], y+dy[command-1]):
    continue
  # 이동
  x = x + dx[command-1]
  y = y + dy[command-1]
  # 굴리기
  roll(command)
  # 지도, 주사위 최신화
  exchange_info()
  # 윗면 출력
  print(dice[0])