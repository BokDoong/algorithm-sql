from collections import deque
import sys
input = sys.stdin.readline

def debug():
    for p in populations:
        print(p)

def canGo(x,y):
    if 0 <= x < N and 0 <= y < N:
        return True
    return False

def canBeUnion(pop):
    if L <= pop <= R:
        return True
    return False

N, L, R = map(int, input().split())
populations = []
for _ in range(N):
    populations.append(list(map(int, input().split())))

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

days = 0
while True:
    isInUnion = [[False for _ in range(N)] for __ in range(N)]
    unions = []
    
    for x in range(N):
        for y in range(N):
            # 이미 연합에 가입되어 있으면 X
            if isInUnion[x][y]:
                continue
            
            # 새로운 연합
            isInUnion[x][y] = True
            newUnion = [(x,y)]
            total = populations[x][y]
            
            # BFS
            queue = deque([(x, y)])
            while queue:
                nowX, nowY = queue.popleft()
                for i in range(4):
                    nextX, nextY = nowX + dx[i], nowY + dy[i]
                    if canGo(nextX, nextY) and not isInUnion[nextX][nextY] and canBeUnion(abs(populations[nextX][nextY]-populations[nowX][nowY])):
                        isInUnion[nextX][nextY] = True
                        total += populations[nextX][nextY]
                        newUnion.append((nextX, nextY))
                        queue.append((nextX, nextY))
                        
            # 새로운 연합의 국가 수가 2개 이상이면 인구이동 연합에 추가
            if len(newUnion) >= 2:
                unions.append((total, newUnion))
                
    if unions:
        for total, nations in unions:
            movedResult = total // len(nations)
            for x, y in nations:
                populations[x][y] = movedResult
        days += 1
    else:
        break

print(days)
