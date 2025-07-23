from collections import deque
import sys
input = sys.stdin.readline

# 스택에다가 하나씩 숫자를 넣으면서 < 비교
def remove():
  global removedCnt
  while numQueue:
    target = numQueue.popleft()
    while stack and stack[-1] < target:
      stack.pop()
      removedCnt += 1
      if removedCnt == K:
        stack.append(target)
        return
    stack.append(target)

# 입력
N, K = map(int, input().split())
numQueue = deque(list(map(int, input().rstrip())))

# 스택, < 비교
stack = [numQueue.popleft()]
removedCnt = 0
remove()

# 넣을 수가 남아있다면 나머지 다 넣기
while numQueue:
  stack.append(numQueue.popleft())

# 아직 제거할 숫자가 남아있다면 뒤에서 빼기
stack = stack[:len(stack)-(K-removedCnt)]
print(''.join(map(str,stack)))