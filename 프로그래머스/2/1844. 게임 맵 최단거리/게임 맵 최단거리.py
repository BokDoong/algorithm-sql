from collections import deque

def canGo(x, y, maxX, maxY, maps):
    if x < 0 or y < 0 or x > maxX or y > maxY:
        return False
    if maps[x][y] == 0:
        return False
    return True

def solution(maps):
    dx, dy = [1,-1,0,0], [0,0,1,-1]     # 이동벡터
    destX, destY = len(maps)-1, len(maps[0])-1     # 목적지
    
    visited = set()
    visited.add((0,0))      # 방문 배열
    
    # BFS
    queue = deque([(0,0,1)])
    while queue:
        nowX, nowY, depth = queue.popleft()
        if nowX == destX and nowY == destY:
            return depth
        
        for i in range(4):
            nextX, nextY = nowX+dx[i], nowY+dy[i]
            if canGo(nextX, nextY, destX, destY, maps) and (nextX, nextY) not in visited:
                visited.add((nextX, nextY))
                queue.append((nextX, nextY, depth+1))
                
    return -1