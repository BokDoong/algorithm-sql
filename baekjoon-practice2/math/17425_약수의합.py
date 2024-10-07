# 각 수의 약수합 구하기
totals = [1] * 1000001
for i in range(2, 1000001):
  for j in range(1, 1000000//i + 1):
    totals[i*j] += i
    
# 누적합 구하기
for i in range(2, 1000001):
  totals[i] += totals[i-1]

# Main    
n = int(input())
results = []
for _ in range(n):
  target = int(input())
  results.append(totals[target])
print('\n'.join(map(str, results)))
