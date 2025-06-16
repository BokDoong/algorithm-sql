import sys
input = sys.stdin.readline

N = int(input().rstrip())
info = {}
for _ in range(N):
  town, people = map(int, input().split())
  info[town] = people

sortedTowns = sorted(info.items(), key = lambda item : item[1], reverse = True)
print(sortedTowns[0][0])