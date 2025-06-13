from collections import deque
import sys
input = sys.stdin.readline

# 소수 판별
def isPrime(num):
  for i in range(2, int(num**0.5)+1):
    if num % i == 0:
      return False
  return True

# 자릿수 바꿔주기
def convertNum(num, pos):
  answer = []
  for i in range(0, 10):
    tmpNum = str(num)
    tmpNum = tmpNum[:pos] + str(i) + tmpNum[pos+1:]
    if 1000 <= int(tmpNum) < 10000:
      answer.append(int(tmpNum))
  return answer

# 1000 ~ 9999 소수
primeNums = set()
for num in range(1000, 10000):
  if isPrime(num):
    primeNums.add(num)
    
# Main
T = int(input().rstrip())
for _ in range(T):
  # 시작, 끝, 방문 및 결과
  start, end  = map(int, input().split())
  visited = set([start])
  flag = False
  
  # 탐색
  queue = deque([(start, 0)])
  while queue:
    num, depth = queue.popleft()
    if num == end:
      flag = True
      print(depth)
      break
    for i in range(4):
      candidates = convertNum(num, i)
      for candidate in candidates:
        if candidate not in visited and candidate in primeNums:
          visited.add(candidate)
          queue.append((candidate, depth+1))
          
  # 없다면 
  if not flag:
    print("Impossible")