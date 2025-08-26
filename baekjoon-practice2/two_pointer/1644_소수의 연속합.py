import sys
input = sys.stdin.readline

# 입력
N = int(input())
result = 0

# 소수 구하기, 소수이면 True
nums = [False, False] + [True]*(N-1)
for i in range(2, int(N**0.5)+1):
  if nums[i]:
    j = 2
    while i*j <= N:
      nums[i*j] = False
      j += 1
      
primes = []
for i in range(N+1):
  if nums[i]:
    primes.append(i)

# 소수 부분합 찾기
left, right = 0, 0
while right <= len(primes):
  sumNum = sum(primes[left:right+1])
  if sumNum == N:
    result += 1
    left += 1
    right += 1
  elif sumNum > N:
    left += 1
  else:
    right += 1
    
print(result)