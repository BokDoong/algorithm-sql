import sys
input = sys.stdin.readline

# 단어개수
N = int(input().rstrip())
S = []
for _ in range(N):
  S.append(input().rstrip())
  
# 단어별 값을 지정
words = {}
for s in S:
  x = len(s)-1
  for i in s:
    if i in words:
      words[i] += 10**x
    else:
      words[i] = 10**x
    x-=1
  
# 딕셔너리 value만
sortedWords = sorted(words.values(),reverse=True)
result = 0
num = 9
for k in sortedWords:
  result += k*num
  num -= 1
print(result)