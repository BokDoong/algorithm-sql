import sys
input = sys.stdin.readline

# Main
# 스와핑
def swap(x, y):
  global heap
  
  tmp = heap[x]
  heap[x] = heap[y]
  heap[y] = tmp

# 삽입
def insert(item):
  global heap
  
  # 끝에 삽입
  heap.append(item)
  
  # 하나 밖에 없으면 정렬 안해도 됨.
  node = len(heap) - 1
  if node == 1:
    return
  
  # 힙 재구성 : 부모랑 게속해서 비교하면서 item 이 더 크면 부모랑 교환
  while node != 1 :
    parent_node = node // 2
    # 부모가 더 작으면 스왑
    if heap[parent_node] < item:
      swap(node, parent_node)
      node = node//2  # 노드 위치 업데이트
    else:
      break
    
# 삭제(=최대값 삭제)
def delete():
  global heap
  length = len(heap) - 1
  
  # 비어있는 경우
  if length == 0:
    print(0)
    return

  # 루트 노드 삭제, 마지막 노드 루트 노트에 삽입
  print(heap[1])
  heap[1] = heap[length]
  heap[length] = 0
  length -= 1

  # 재구성
  node = 1
  while node*2 <= length:
    left_son = node*2
    right_son = node*2 + 1
    
    # 자식보다 크면 끝
    if heap[node] >= heap[left_son] and heap[node] >= heap[right_son]:
      break
    
    # 왼쪽 vs 오른쪽 중에 큰 자식이랑 스왑
    if heap[left_son] > heap[right_son]:
      swap(left_son, node)
      node = node*2
    else:   
      swap(right_son, node)
      node = node*2 + 1
    
  # 마지막 노드(0)삭제
  del heap[length+1]
  return


# Input
heap = [0]
n = int(input())
for _ in range(n):
  command = int(input())
  if command == 0:
    delete()
  else:
    insert(command)