from collections import deque
import sys
input = sys.stdin.readline

def debug(stack, remains, goods, result):
  print("goods ", goods)
  print("stack ", stack)
  print("remains", remains)
  print("result ", result)

N, M = map(int, input().split())

# 우선순위별 화물 개수
priorityGoods = {}
for i in range(1, M+1):
  priorityGoods[i] = 0
  
# 넣어야할 화물의 순서 : (P, W)
goods = deque([])
for _ in range(N):
  P, W = map(int, input().split())
  priorityGoods[P] += 1
  goods.append((P, W))

# 적재
priority, result = M, 0
remains, stack = deque([]), deque([])

for p in range(priority, 0, -1):
  while priorityGoods[p] > 0:
    # 지금 실어야하는 물품(now)
    nowP, nowW = goods.popleft()
    
    # 우선순위가 낮다면 적재 + 해당 우선순위의 넣어야할 개수에서 빼기
    if nowP > p:
      result += nowW
      stack.append((nowP, nowW))
      priorityGoods[nowP] -= 1
    # 우선순위가 높다면 맨뒤로 보내기
    elif nowP < p:
      goods.append((nowP, nowW))
      result += nowW
    # 우선순위가 같다면
    else:
      if not stack:
        stack.append((nowP, nowW))
        priorityGoods[nowP] -= 1
        result += nowW
      else:
        tmpW = 0
        while stack:
          stackP, stackW = stack[-1]
          if stackP == nowP and stackW < nowW:
            sp, sw = stack.pop()
            tmpW += (sw*2)
            remains.append((sp, sw))
          else:
            break
          
        stack.append((nowP, nowW))
        while remains:
          rp, rw = remains.pop()
          stack.append((rp, rw))
        
        priorityGoods[nowP] -= 1
        result += nowW
        result += tmpW
        
print(result)