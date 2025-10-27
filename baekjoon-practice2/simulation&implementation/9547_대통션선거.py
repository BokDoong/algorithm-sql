import heapq
import sys
input = sys.stdin.readline

def solve(C, V):
  
  # 후보 번호 : 뽑힌 횟수
  represents = {}
  
  # 유권자의 선호하는 후보 우선순위
  favorites = []
  for _ in range(V):
    fav = list(map(int, input().split()))
    favorites.append(fav)

    if fav[0] in represents:
      represents[fav[0]] += 1
    else:
      represents[fav[0]] = 1
      
  # 최대힙에 넣기
  heap = []
  for c in represents:
    heapq.heappush(heap, (-1*represents[c], c))
      
  # 첫번째 투표
  count, maxRepresent = heapq.heappop(heap)
  if -1*count > int(V*(1/2)):
    result.append([maxRepresent, 1])
    return

  # 두번째 투표
  count2, maxRepresent2 = heapq.heappop(heap)
  secondVotes = [0, 0]
  for fav in favorites:
    for f in fav:
      if f == maxRepresent:
        secondVotes[0] += 1
        break
      elif f == maxRepresent2:
        secondVotes[1] += 1
        break
  
  if secondVotes[0] > secondVotes[1]:
    result.append([maxRepresent, 2])
  else:
    result.append([maxRepresent2, 2])
    

T = int(input().rstrip())
result = []
for _ in range(T):
  C, V = map(int, input().split())
  solve(C, V)
  
for r in result:
  print(*r)