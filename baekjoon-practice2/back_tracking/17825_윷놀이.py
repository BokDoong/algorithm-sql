import sys
input = sys.stdin.readline


# 윷놀이 판 : 이동할 수 있는 다음칸 지정
graph = [[1], [2], [3], [4], [5],
         [6, 21], [7], [8], [9], [10],
         [11, 25], [12], [13], [14], [15],
         [16, 27], [17], [18], [19], [20],
         [32], [22], [23], [24], [30],
         [26], [24], [28], [29], [24],
         [31], [20], [32]]

# 칸 별로 점수
score = [0, 2, 4, 6, 8,
         10, 12, 14, 16, 18,
         20, 22, 24, 26, 28,
         30, 32, 34, 36, 38,
         40, 13, 16, 19, 25,
         22, 24, 28, 27, 26,
         30, 35, 0]

# Input : 주사위, 결과
dice = list(map(int, input().split()))
result= 0


# Main
def solve(depth, now_score, horses):
  global result
  
  # 10번
  if depth == 10:
    result = max(result, now_score)
    return
  
  # 말 하나씩 백트래킹
  for i in range(4):
    # 말 위치
    x = horses[i]
    
    # 말 위치 이동 -> 파란색 화살표인지 체크
    if len(graph[x]) == 2:
      x = graph[x][1]
    else:
      x = graph[x][0]
      
    # 이동
    for _ in range(1, dice[depth]):
      x = graph[x][0]
      
    # 도착점
    if x == 32 or (x < 32 and x not in horses):
      before = horses[i]
      horses[i] = x
      
      solve(depth+1, now_score+score[x], horses)
      
      horses[i] = before
      
      
      
# Output
solve(0, 0, [0,0,0,0])
print(result)