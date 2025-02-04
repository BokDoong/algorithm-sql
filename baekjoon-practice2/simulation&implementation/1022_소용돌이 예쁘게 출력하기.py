# import sys
# input = sys.stdin.readline

# # 출력 시작/끝 좌표
# r1, c1, r2, c2 = map(int, input().split())

# # 10000x10000 배열 만들기
# board = [[0]*10001 for _ in range(10001)]

# # 가운데 값 설정
# board[5000][5000] = 1

# # 시작값, 시작좌표
# n = 2
# x, y = 5001, 5001

# # 소용돌이 만들기
# while n < 5002:
#   val = (2*n-1)**2
#   for i in range(2*n-2):    # 좌
#     board[x][y] = val
#     val -= 1
#     y -= 1
#   for i in range(2*n-2):    # 상
#     board[x][y] = val
#     val -= 1
#     x -= 1
#   for i in range(2*n-2):    # 우
#     board[x][y] = val
#     val -= 1
#     y += 1
#   for i in range(2*n-2):    # 하
#     board[x][y] = val
#     val -= 1
#     x += 1
  
#   # 다음 이동
#   x += 1
#   y += 1
#   n += 1
  
# # 출력
# output = []
# maxNum = -sys.maxsize
# for i in range(r1+5000, r2+5001):
#   tmp = []
#   for j in range(c1+5000, c2+5001):
#     target = board[i][j]
#     maxNum = max(maxNum, target)
#     tmp.append(target)
#   output.append(tmp)
  
# maxLength = len(str(maxNum))
# for i in range(r1+5000, r2+5001):
#   line = ''
#   for j in range(c1+5000, c2+5001):
#     line += ' '*(maxLength-len(str(board[i][j])))
#     line += str(board[i][j])
#     line += ' '
#   print(line)

import sys
input = sys.stdin.readline

def getValue(r,c):
    n=max(abs(r), abs(c))
    last= (2*n+1)**2

    if r==n:#아래 변
        return last-(n-c)
    elif c==-n:#왼쪽 변
        return last-(2*n)-(n-r)
    elif r==-n:#윗 변
        return last-(4*n)-(n+c)
    else: #오른쪽 변
        return last-(6*n)-(n+r)

r1,c1,r2,c2 = map(int,input().split())
tonado = []

for x in range(r1,r2+1):
    for y in range(c1,c2+1):
        tonado.append(str(getValue(x,y)))
    tonado.append('\n')

# 최대 자리수 찾기
digit = 0
for i in range(len(tonado)):
    if tonado[i] == '\n':
        continue
    digit = max(digit,len(tonado[i]))

# 정답 행렬 예쁘게 바꾸기
for i in range(len(tonado)):
    if tonado[i] == '\n':
        continue
    tonado[i] = tonado[i].rjust(digit,' ')
    
# 최종 정답 행렬 예쁘게 출력
for i in range(len(tonado)):
    if tonado[i] == '\n':
        print()
    else:
        print(tonado[i],end=' ')