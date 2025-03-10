import copy
from collections import deque
import sys
input = sys.stdin.readline

# 돌리기
def solution(tmpColors):
  global cube
  tmpCube = copy.deepcopy(cube)
  # 회전시킬 큐브판
  deqColors = deque([])
  for i in range(8):
    deqColors.append(tmpCube[tmpColors[i]])
    
  # 우회전
  deqColors.rotate(2)
  for i in range(8):
    tmpCube[tmpColors[i]] = deqColors[i]
  checkColors(tmpCube)
  # 좌회전
  deqColors.rotate(-4)
  for i in range(8):
    tmpCube[tmpColors[i]] = deqColors[i]
  checkColors(tmpCube)
  

# 색이 같은지 보기
def checkColors(tmpCube):
  for i in range(0, 20, 4):
    colors = set(tmpCube[i:i+4])
    if len(colors) > 1:
      return
  print(1)
  exit()
  
# 전개도
cube = list(map(int, input().split()))

# 회전
tmpColors = [0,2,4,6,8,10,23,21]
solution(tmpColors)
tmpColors = [1,3,5,7,10,11,22,20]
solution(tmpColors)
tmpColors = [12,13,4,5,16,17,20,21]
solution(tmpColors)
tmpColors = [14,15,6,7,18,19,22,23]
solution(tmpColors)
tmpColors = [2,3,16,18,9,8,15,13]
solution(tmpColors)
tmpColors = [0,1,17,19,11,10,14,12]
solution(tmpColors)
print(0)