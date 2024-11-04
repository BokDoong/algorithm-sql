import sys

# Input
n = int(input())
cost = [list(map(int, input().split())) for _ in range(n)]
cities = [i for i in range(n)]
visted = [False] * n
result = sys.maxsize

# Permutation Methods
def swap(idx):
  global cities, swap_idx
  tmp = cities[swap_idx]
  cities[swap_idx] = cities[idx]
  cities[idx] = tmp
  
def sort_nums():
  global cities, swap_idx
  tmp_cities = cities[swap_idx+1:]
  tmp_cities.sort()
  cities[swap_idx+1:] = tmp_cities
  
def find_and_swap_nums():
  global cities, n
  for i in range(n-1, 0, -1):
    if cities[swap_idx] < cities[i]:
      swap(i)
      sort_nums()
      return
  
def swap_possible():
  global n, cities, swap_idx
  for i in range(n-1, 0, -1):
    if cities[i] > cities[i-1]:
      swap_idx = i-1
      return True
  return False

def calculate_cost():
  # 마지막-처음
  global cities, cost, n, result
  tmp = cost[cities[-1]][cities[0]]
  if tmp == 0:
    return
  
  # 이동하면서 계산
  for c in range(1, n):
    next = cost[cities[c-1]][cities[c]]
    if next != 0:
      tmp += next
    else:
      return
    
  # 최종값 비교
  result = min(result, tmp)
    
def solve():
  cities.sort()
  while swap_possible():
    find_and_swap_nums()
    calculate_cost()
  return
    
# Main
solve()
print(result)