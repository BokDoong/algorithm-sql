import sys
input = sys.stdin.readline

# 백트래킹
def backTracking(total):
  global result, n
  
  # 종료
  if total == n:
    result += 1
    return
  # 범위 벗어나는지
  if total>n:
    return
  # 탐색
  backTracking(total+1)
  backTracking(total+2)
  backTracking(total+3)
  

# 테스트 케이스
T = int(input())

# 탐색
for _ in range(T):
  result = 0
  n = int(input().rstrip())
  backTracking(0)
  print(result)