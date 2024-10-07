# 전체 소수인지 체크해두는 배열
nums = [0] * 1000001
nums[1] = 1

# 소수 마스킹
for i in range(2, 1001):
  if not nums[i]:
    tmp = 2
    while True:
      if i*tmp > 1000000:
        break
      nums[i*tmp] = 1
      tmp += 1
  
# 골드 바흐의 추측
def guess_gold(n):
  flag = False
  for i in range(2, n//2+1):
    if not nums[i] and not nums[n-i]:
      print("{} = {} + {}".format(n, i, n-i))
      flag = True
      break
  if not flag:
    print("Goldbach's conjecture is wrong.")
  
# Main    
while True:
  n = int(input())
  if n == 0:
    break
  guess_gold(n)
