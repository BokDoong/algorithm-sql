# 길이, 결과값
num = int(input())
n = len(str(num))
result = 0

# N-1 까지 카운팅
for i in range(1, n):
  result += i * 9 * 10**(i-1)

# 결과
result += (num - 10**(n-1) + 1) * n
print(result)