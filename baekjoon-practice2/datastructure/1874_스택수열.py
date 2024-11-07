from collections import deque
'''
result : 
stack : 1 5 7
nums : 9 7 5
---
1) top == target : stack을 pop
2) top > target : 나올 떄까지 pop, nums에 push, target 나오면 result
3) top < target : nums를 pop해서 stack에 push, target이 들어가면 stack을 pop, target 나오면 result
'''

# Main
n = int(input())
nums = [i for i in range(n, 0, -1)]
stack = [0]
result = deque([])

for _ in range(n):
  target = int(input())
  while True:
    if target == stack[-1]:
      stack.pop()
      result.append('-')
      break
    elif target > stack[-1]:
      stack.append(nums.pop())
      result.append('+')
      continue
    else:
      print('NO')
      exit()

while len(result) > 0:
  print(result.popleft())    