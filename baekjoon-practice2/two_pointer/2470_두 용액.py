import sys
input = sys.stdin.readline

# N
N = int(input().rstrip())
# 용액
liquids = list(map(int,input().split()))
liquids.sort()

# 투포인터
result = sys.maxsize
start, end = 0, N-1
startResult, endResult = liquids[start], liquids[end]
while start < end:
  total = liquids[start]+liquids[end]
  
  # 차이 비교
  if abs(0-total) < result:
    result = abs(0-total)
    startResult, endResult = liquids[start], liquids[end]
  
  # 포인터 이동
  if total < 0:
    start+=1
  elif total > 0:
    end-=1
  else:         # 0이면 종료
    startResult, endResult = liquids[start], liquids[end]
    break
    
# 결과
print(startResult, endResult)

