import sys
input = sys.stdin.readline

# 나무 길이 계산
def calculateLength(norm):
  global trees
  answer = 0
  for tree in trees:
    if tree <= norm:
      continue
    else:
      answer += (tree-norm)
  return answer

# N,M
N, M = map(int, input().split())
# 나무
trees = list(map(int, input().split()))
trees.sort()

# 이분 탐색
result = 0
start, end = 1, trees[-1]
while start <= end:
  mid = (start+end)//2
  length = calculateLength(mid)
  if length > M:
    start = mid + 1
    result = mid
  elif length < M:
    end = mid - 1
  else:
    result = mid
    break
  
print(result)