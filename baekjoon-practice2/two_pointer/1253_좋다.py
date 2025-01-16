import sys
input = sys.stdin.readline

# Input
N = int(input())
nums = list(map(int, input().split()))
nums.sort()


# Main
result = 0
for i in range(N):
  temp = nums[:i] + nums[i+1:]    # 해당 인덱스 제외한 리스트 생성
  start, end = 0, len(temp) - 1   # 시작, 끝 포인터 설정
  
  while start < end:
    total = temp[start] + temp[end]
    if total == nums[i]:
      result += 1
      break
    elif total < nums[i]:
      start += 1
    else:
      end -= 1


# Output
print(result)