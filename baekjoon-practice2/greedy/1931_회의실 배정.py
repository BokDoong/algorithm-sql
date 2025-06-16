import sys
input = sys.stdin.readline

N = int(input())
time = []

for _ in range(N):
  start, end = map(int, input().split())
  time.append([start, end])
  
time = sorted(time, key = lambda x: (x[1], x[0]))

last = 0    # 회의 마지막 시간
cnt = 0     # 회의 개수

for i, j in time:
  if i >= last:
    cnt += 1
    last = j
  
print(cnt)