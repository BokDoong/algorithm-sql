from collections import deque
import sys
input = sys.stdin.readline

def solve():
    N, K = map(int, input().split())
    constructionTimes = list(map(int, input().split()))     # 건설 시간
    
    connectedInfos = {}     # 연결된 노드 정보
    for n in range(1, N+1):
        connectedInfos[n] = []
    for _ in range(K):
        start, end = map(int, input().split())
        connectedInfos[end].append(start)
        
    costs = {}      # 각 건물을 완성하는데 걸리는 누적 시간
    for n in range(1, N+1):
        costs[n] = constructionTimes[n-1]
        
    W = int(input().rstrip())       # 목표 노드
    
    queue = deque([])       # 아무도 연결되어 있지않은 노드
    for i in range(1, N+1):
        if len(connectedInfos[i]) == 0:
            queue.append((i, constructionTimes[i-1]))
            
    while queue:
        node, untilNow = queue.popleft()
        # 목표 도달
        if node == W:
            return untilNow
        # 연결된 노드가 있다면 제거
        for n in range(1, N+1):
            if node in connectedInfos[n]:
                connectedInfos[n].remove(node)
                costs[n] = max(costs[n], constructionTimes[n-1]+untilNow)
                if connectedInfos[n] == []:
                    queue.append((n, costs[n]))

T = int(input().rstrip())
for _ in range(T):
    result = solve()
    print(result)
