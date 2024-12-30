import sys
input = sys.stdin.readline

# Input
N, L = map(int, input().split())
board = []
for _ in range(N):
  board.append(list(map(int, input().split())))
  
  
# Methods
# 지도에서 안벗어나는지 체크
def can_set_start_point(point):
  global N
  
  if 0 <= point < N:
    return True
  return False

# 지나갈 수 있는지
def can_go(road):
  global L
  
  # 경사로 생기는 곳
  visited = [False for _ in range(N)]
  
  # 자리 차례로 탐색
  for i in range(0, N-1):
    # 높이 같으면 Pass
    if road[i] == road[i+1]:
      continue
    
    # 차이가 1 넘게 나면 못지나감
    if abs(road[i]-road[i+1]) > 1:
      return False
    # 다음 위치가 한 층 낮으면 
    elif road[i] > road[i+1]:
      height = road[i+1]  # 경사로 놓을 높이
      for j in range(i+1, i+L+1):
        # 경사 길이가 범위 안이어야함.
        if can_set_start_point(j):
          if height != road[j]:   # 놓을 곳의 높이가 다 같은지 체크
            return False
          elif visited[j]:  # 이미 경사로가 놓여졌는지 체크
            return False
          # 경사 놓기
          visited[j] = True
        # 경사 길이가 벗어남.
        else :
          return False
    # 다음 위치가 한 층 높으면
    else:
      height = road[i]  # 경사로 놓을 높이
      for j in range(i, i-L, -1):
        # 경사 길이가 범위 안이어야함.
        if can_set_start_point(j):
          if height != road[j]:   # 놓을 곳의 높이가 다 같은지 체크
            return False
          elif visited[j]:  # 이미 경사로가 놓여졌는지 체크
            return False
          # 경사 놓기
          visited[j] = True
        # 경사 길이가 벗어남.
        else :
          return False
        
  return True


# Main
result = 0

# 가로길 체크
for road in board:
  if can_go(road):
    result += 1

# 세로길 체크
for i in range(N):
  road = []
  for j in range(N):
    road.append(board[j][i])
  if can_go(road):
    result += 1
    

# Output
print(result)