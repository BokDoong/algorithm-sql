import sys
input = sys.stdin.readline

N, K = map(int, input().split())
electrics = list(map(int, input().split()))

plug = [0] * N
electricsInPlug = set()
result = 0

for e in range(len(electrics)):
  # 이미 있다면 넘어간다.
  if electrics[e] in electricsInPlug:
    continue
  # 빈자리를 찾아서 꼽는다.
  put = False
  for i in range(len(plug)):
    if plug[i] == 0:
      plug[i] = electrics[e]
      electricsInPlug.add(electrics[e])
      put = True
      break
  if put:
    continue
  # 다 차있다면 가장 늦게 오거나 다음에 오지 않는 것을 뺀다.
  # 하나씩 탐색해서 다음 위치를 본다.
  nextPos = [sys.maxsize]*N
  for np in range(N):
      k = e + 1
      while k < K:
          if electrics[k] == plug[np]:
              nextPos[np] = k
              break
          k += 1
  targetPos = nextPos.index(max(nextPos))
  
  targetPos = nextPos.index(max(nextPos))
  electricsInPlug.remove(plug[targetPos])
  plug[targetPos] = electrics[e]
  electricsInPlug.add(electrics[e])
  result += 1
  
print(result)