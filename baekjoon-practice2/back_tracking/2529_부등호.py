import sys
input = sys.stdin.readline


# 최대, 최소값 갱신
def renewMaxMinNums(nums):
  global maxNum, minNum
  
  # 최대값 갱신
  if int(nums) > int(maxNum):
    maxNum = nums
  # 최소값 갱신
  if int(nums) < int(minNum):
    minNum = nums


# 백트래킹
def backTracking(depth, nums):
  global N, commands, maxNum, minNum
  
  # 탐색 끝
  if depth == N:
    renewMaxMinNums(nums)
    return
  
  # 탐색
  for val in range(10):
    # 이미 방문했는지 확인
    if visited[val]:
      continue
    # <
    if commands[depth] == '<' and int(nums[-1]) < val:
      visited[val] = True
      nums+=str(val)
      backTracking(depth+1, nums)
      nums=nums[:-1]
      visited[val] = False
    # >
    if commands[depth] == '>' and int(nums[-1]) > val:
      visited[val] = True
      nums+=str(val)
      backTracking(depth+1, nums)
      nums=nums[:-1]
      visited[val] = False
    
    
# 부등호 갯수
N = int(input())

# 부등호
commands = list(input().split())

# 최대,최소값
maxNum = str(-sys.maxsize)
minNum = str(sys.maxsize)

# 방문
visited = [False] * 10

# 탐색
for i in range(10):
  visited[i] = True
  backTracking(0, str(i))
  visited[i] = False


# Output
print(maxNum)
print(minNum)