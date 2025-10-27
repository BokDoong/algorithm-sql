import sys
input = sys.stdin.readline

N, M, Q = map(int, input().split())

# 은닉층
hides = []
for _ in range(M):
  hides.append(list(map(int, input().split())))
  
# 출력층
outputs = list(map(int, input().split()))

# 편향
bias = outputs[-1]

# 결과에 어떻게 반영되는지 계산
counts = [0] * N
for m in range(M):
  hide = hides[m]
  c, b = hide[0], hide[-1]
  idxs, weights = hide[1:1+c], hide[1+c:1+c+c]
  
  for i in range(c):
   counts[idxs[i]-1] += weights[i]*outputs[m]
  bias += b*outputs[m]

# 입력층
results = []
for _ in range(Q):
  inputs = list(map(int, input().split()))
  result = 0
  for i in range(N):
    result += counts[i]*inputs[i]
  result += bias
  results.append(result)
  
# 출력
for r in results:
  print(r)