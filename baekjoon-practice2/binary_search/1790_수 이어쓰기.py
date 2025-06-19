import math
import sys
input = sys.stdin.readline

# 입력
N, K = map(int, input().split())

# 몇 번째 자릿수인지
length = 0
digit = 1
count = 9

# 총 자릿수 누적합으로 K번째 존재하는지 확인
while K > count * digit:
  K -= count * digit
  length += count * digit
  digit += 1
  count *= 10
  
# 찾는 숫쟈ㅏ
number = 10**(digit-1) + (K-1) // digit
if number > N:
  print(-1)
else:
  print(str(number)[(K-1)%digit])