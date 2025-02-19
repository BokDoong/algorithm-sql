import sys
input = sys.stdin.readline

# 회문 찾기
def findPalindrome(val):
  # 포인터, 지운 개수
  left, right = 0, len(val)-1
  
  # 찾기
  while left < right:
    # 다르면
    if val[left] != val[right]:
      # 왼쪽 제거
      removeLeft = val[left+1:right+1]
      if removeLeft == removeLeft[::-1]:
        return 1
      # 오른쪽 제거
      removeRight = val[left:right]
      if removeRight == removeRight[::-1]:
        return 1
      
      return 2
      
    left += 1
    right -= 1

  # 결과
  return 0

# Main
T = int(input().rstrip())
for _ in range(T):
  print(findPalindrome(input().rstrip()))