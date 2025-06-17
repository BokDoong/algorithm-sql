# Input
N = int(input())

# 문자열 입력
words = []
for _ in range(N):
  words.append(input())
  
# Enumeration
for x in enumerate(words):
  words[x[0]] = x
  
  
# Main
# 접두사 비교
def check(x,y):
  cnt = 0
  min_len = min(len(x), len(y))
  for i in range(min_len):
    if x[i] == y[i]:
      cnt += 1
    else:
      return cnt
  return cnt
  
# 하나씩 비교
max_len = [-1, -1, 0]
for x in range(N):
  for y in range(x+1, N):
    cur = check(words[x][1], words[y][1])
    if max_len[2] < cur:
      max_len[0] = x
      max_len[1] = y
      max_len[2] = cur
      
      
# Output
print(words[max_len[0]][1])
print(words[max_len[1]][1])