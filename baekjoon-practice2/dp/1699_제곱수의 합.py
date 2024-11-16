# Main
result = []
result.append(0)
result.append(1)
result.append(2)

for num in range(3, 100001):
  half = int(num**(1/2))
  tmp = 100001
  for i in range(1, half+1):
    tmp = min(tmp, 1 + result[num - i**2])
  result.append(tmp)

# Output
target = int(input())
print(result[target])