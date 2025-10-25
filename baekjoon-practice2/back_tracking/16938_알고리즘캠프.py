import sys
input = sys.stdin.readline

N, L, R, X = map(int, input().split())
A = list(map(int, input().split()))

def backTracking(nums, n, total):
  global answer
  if len(nums) >= 2 and L <= total <= R and nums[-1] - nums[0] >= X:
    answer += 1
  
  if n == N:
    return
  
  for i in range(n, N):
    nums.append(A[i])
    total += A[i]
    backTracking(nums, i+1, total)
    nums.pop()
    total -= A[i]
    
A.sort()
answer = 0
backTracking([], 0, 0)
print(answer)