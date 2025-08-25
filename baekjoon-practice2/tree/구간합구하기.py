import sys
input = sys.stdin.readline

def buildTree(x, left, right):
  if left == right:
    segTree[x] = num[left]
    return segTree[x]
  mid = (left + right) // 2
  leftValue = buildTree(2*x, left, mid)
  rightValue = buildTree(2*x+1, mid+1, right)
  segTree[x] = leftValue + rightValue
  return segTree[x]

def findSum(b, c, x, left, right):
  if c < left or right < b:
    return 0
  if b <= left and right <= c:
    return segTree[x]
  mid = (left+right)//2
  leftValue = findSum(b, c, x*2, left, mid)
  rightValue = findSum(b, c, x*2+1, mid+1, right)
  return leftValue + rightValue

def updateTree(x, left, right, idx, val):
  if left == right == idx:
    segTree[x] = val
    return
  if idx < left or right < idx:
    return
  mid = (left+right)//2
  updateTree(x*2, left, mid, idx, val)
  updateTree(x*2+1, mid+1, right, idx, val)
  segTree[x] = segTree[x*2] + segTree[x*2+1]
  

n,m,k = map(int,input().split())
num = [int(input()) for _ in range(n)]
segTree = [0 for _ in range(4*n)]

buildTree(1,0,n-1)

for _ in range(m+k):
    a,b,c = map(int,input().split())
    # b번째 수를 c로 바꾸기
    if a == 1:
        updateTree(1,0,n-1,b-1,c)
    # b번째 수부터 c번째 수까지 합 구하기
    else:
        s = findSum(b-1,c-1,1,0,n-1)
        print(s)