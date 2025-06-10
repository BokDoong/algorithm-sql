def solution(arrows):
    # 이동 벡터
    dx = [0, 1, 1, 1, 0, -1, -1, -1]
    dy = [-1, -1, 0, 1, 1, 1, 0, -1]
    
    # 시작점, 방문 노드/간선
    x, y = 0, 0
    visitedNodes = set()
    visitedNodes.add((x,y))
    visitedRoutes = set()
    
    # 탐색
    cycle = 0 
    for arrow in arrows:
        # 교차점을 정점으로 만들기 위해 2씩 이동
        for _ in range(2):
            nx, ny = x + dx[arrow], y + dy[arrow]
            if (nx, ny) in visitedNodes and (x, y, nx, ny) not in visitedRoutes:
                cycle += 1
            visitedRoutes.add((x, y, nx, ny))
            visitedRoutes.add((nx, ny, x, y))
            visitedNodes.add((nx, ny))
            x, y = nx, ny
    
    return cycle