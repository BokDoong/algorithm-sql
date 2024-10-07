# 전체 소수인지 체크해두는 배열
nums = [0] * 1000001
nums[1] = 1
# 마스킹 배열
board = [0] * 1001
board[1] = 1

# Main
for i in range(2, 1001):
  if board[i] == 0:
    tmp = 2
    while True:
      if i*tmp > 1000000:
        break
      nums[i*tmp] = 1
      tmp += 1
      
start, end = map(int, input().split())
for i in range(start, end+1):
  if nums[i] == 0:
    print(i)
