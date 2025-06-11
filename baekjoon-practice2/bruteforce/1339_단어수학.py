import sys
input = sys.stdin.readline

# Input
N = int(input().rstrip())
numbers = []
for _ in range(N):
  numbers.append(input().rstrip())

# 알파벳
alphabets = [0] * 26
for number in numbers:
  for i in range(len(number)):
    alphabets[ord(number[i])-65] += 10**(len(number)-1-i)

# 정렬해서 출력
alphabets.sort(reverse=True)
answer, cnt = 0, 9
for i in range(10):
  answer += (alphabets[i]*cnt)
  cnt -= 1
  
print(answer)
