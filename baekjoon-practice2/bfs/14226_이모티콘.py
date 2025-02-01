from collections import deque

# Input 
target = int(input())

# Main
# (현재 스티커, 클립보드 스티커, 깊이)
queue = deque([(1, 0)])
# (스티커, 클립보드) 저장할 배열
dp = [[-1] * (target+1) for _ in range(target+1)]
dp[1][0] = 0

while queue:
  # 현재 스티커 수, 클립보드, 깊이
  stickers, clipboard = queue.popleft()
  depth = dp[stickers][clipboard]
  
  # 연산(1) - 클립보드에 저장
  if dp[stickers][stickers] == -1:
    dp[stickers][stickers] = depth+1
    queue.append((stickers, stickers))
    
  # 연산(2) - 삭제
  if stickers-1 >= 0 and dp[stickers-1][clipboard] == -1:
    dp[stickers-1][clipboard] = depth+1
    queue.append((stickers-1, clipboard))
    
  # 연산(3) - 붙여넣기
  if stickers+clipboard <= target and dp[stickers+clipboard][clipboard] == -1:
    dp[stickers+clipboard][clipboard] = depth+1
    queue.append((stickers+clipboard, clipboard))
    
    
# Output
print(min(dp[target][1:]))