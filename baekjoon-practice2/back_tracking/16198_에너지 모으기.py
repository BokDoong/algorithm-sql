import sys
input = sys.stdin.readline


# 백트래킹
def backTracking(remains, savedEnergy):
  global result
  
  # 2개 밖에 안남았으면 끝
  length = len(remains)
  if length == 2:
    result = max(result, savedEnergy)
    return
  
  # 사이에 있는 구슬들 하나씩 제거
  for i in range(1, length-1):
    removedEnergy = remains[i]
    energy = remains[i-1]*remains[i+1]
    del remains[i]
    backTracking(remains, savedEnergy+energy)
    remains.insert(i, removedEnergy)


# 구슬 개수
N = int(input().rstrip())

# 구슬(무게)
beads = list(map(int, input().split()))

# 에너지
result = 0


# Output
backTracking(beads, 0)
print(result)