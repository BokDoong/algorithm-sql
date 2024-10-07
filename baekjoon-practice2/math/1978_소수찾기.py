def is_prime(n):
  if n < 2:
    return False
  for i in range(2, int(n**0.5) + 1):
    if n % i == 0:
      return False
  return True


cnt = int(input())
nums = list(map(int, input().split()))
result = 0 
for i in nums:
  if is_prime(i):
    result += 1
    
print(result)
