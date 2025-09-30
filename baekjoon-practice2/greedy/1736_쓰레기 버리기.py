import sys
input = sys.stdin.readline

N, M = map(int, input().split())
rooms = []
for _ in range(N):
  rooms.append(list(map(int, input().split())))
  
result = 0
while True:
  curCol = 0
  for x in range(N):
    # 가장 끝의 쓰레기 위치를 구한다.
    end = -1
    for y in range(M-1, -1, -1):
      if rooms[x][y] == 1:
        end = y
        break
    # curCol 보다 같거나 크다면 curCol ~ end 까지 제거, curCol 업대이트
    if end >= curCol:
      for i in range(curCol, end+1):
        rooms[x][i] = 0
      curCol = end
  result += 1
  
  # 아무것도 안남았는지 체크 : 10000
  isEnd = True
  for x in range(N):
    for y in range(M):
      if rooms[x][y] == 1:
        isEnd = False
        break
  if isEnd:
    break
  
print(result)