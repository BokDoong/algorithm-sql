# Main
def solve(start, depth, indexes):
  global N, S, totals
  
  # 합 체크
  total = 0
  for idx in indexes:
    total += S[idx]
  totals[total] = True
  
  # 탐색
  for i in range(start, N):
    if i in indexes:
      continue
    
    indexes.append(i)
    solve(i, depth+1, indexes)
    indexes.pop()
    

# Input
N = int(input())
S = list(map(int, input().split()))
totals = [False] * (sum(S)+1)


# Main
solve(0, 0, [])


# Output
for i in range(1, len(totals)):
  if not totals[i]:
    print(i)
    exit()

# 합까지 모두 표현 가능하면, 다 합친거에서 +1
print(sum(S)+1)