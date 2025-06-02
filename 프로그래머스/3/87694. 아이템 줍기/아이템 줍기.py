from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[-1]*102 for _ in range(102)]     # 그래프 크기*2
    visited = [[0]*102 for _ in range(102)]
    
    # 길이가 1인 모든 선분 저장, *2해서 갖고옴
    edges = set()
    for elem in rectangle:
        lx, ly, rx, ry = map(lambda x:x*2, elem)
        for i in range(lx, rx+1):
            for j in range(ly, ry+1):
                if lx < i < rx and ly < j < ry:     # 사각형 안에 있는 애들은 0으로 처리
                    graph[i][j] = 0
                elif graph[i][j] != 0:      # 선분은 1로 처리
                    graph[i][j] = 1
    
    # BFS
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    queue = deque()
    queue.append((characterX*2, characterY*2))
    while queue:
        x, y = queue.popleft()
        if x == itemX*2 and y == itemY*2:
            answer = visited[x][y]//2
            break
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 < nx < 102 and 0 < ny < 102 and not visited[nx][ny]:
                if graph[nx][ny] == 1:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx, ny))
                    
    return answer