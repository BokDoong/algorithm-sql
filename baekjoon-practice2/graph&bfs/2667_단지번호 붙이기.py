from collections import deque

# Input & 초기화
N = int(input())
board = []
for _ in range(N):
  board.append(list(map(int,input())))    # 집인지 아닌지 저장배열
  
# town_info = [0] * (N+1)
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]    # 이동 위한 벡터


# Main
# 노드 벗어나는지 확인
def can_move_node(x, y):
  global N
  
  if x < 0 or x >= N or y < 0 or y >= N:
    return False
  return True

# 단지 탐색
def find_house_in_town(start):
  global town, board, dx, dy

  # 시작 노드 셋팅
  board[start[0]][start[1]] = 0
  queue = deque([start])
  while(queue):
    # 현재 노드
    now = queue.popleft()
    
    # 주변 노드 확인
    for i in range(4):
      # 다음 노드
      nextX = now[0] + dx[i]
      nextY = now[1] + dy[i]
      
      # 보드 안벗어나는지 확인
      if can_move_node(nextX, nextY):
        # 집인지 확인
        if board[nextX][nextY] == 1:
          queue.append((nextX, nextY))    # 큐에 추가
          board[nextX][nextY] = 0   # 벽으로 수정
          town += 1


# Output
# 집 탐색, 단지 정하기
town_info = []
for i in range(N):
  for j in range(N):
    if board[i][j] == 1:
      town = 1
      find_house_in_town((i, j))
      town_info.append(town)
      
# 단지 개수 세기
town_info.sort()
print(len(town_info))
for t in town_info:
  print(t)