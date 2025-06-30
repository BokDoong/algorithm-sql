from collections import deque
import sys
input = sys.stdin.readline

# 입력
values = input().rstrip()
boom = input().rstrip()
boomLen = len(boom)

# Main
stack = []
for v in values:
  stack.append(v)
  if stack[-1] == boom[-1] and ''.join(stack[-boomLen:]) == boom:
    del stack[-boomLen:]
    
if len(stack) == 0:
  print('FRULA')
else:
  print(''.join(stack))