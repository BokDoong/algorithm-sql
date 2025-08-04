import sys
from collections import deque
input = sys.stdin.readline

# 상하좌우
dirs = [(1,0),(-1,0),(0,1),(0,-1)]

N, M = map(int, input().split())
# 1. 패딩 기법: 맵 외곽을 모두 0(공기)으로 둘러싼다
cheese = [[0]*(M+2)]
for _ in range(N):
    row = list(map(int, input().split()))
    cheese.append([0] + row + [0])
cheese.append([0]*(M+2))

N += 2; M += 2

# 초기 치즈 좌표 수집 (패딩된 좌표 기준)
cheeseQueue = deque()
for i in range(1, N-1):
    for j in range(1, M-1):
        if cheese[i][j] == 1:
            cheeseQueue.append((i,j))

def mark_external_air():
    """치즈가 아닌 칸(0 또는 2)을 통해 내부 빈 공간(0)을 모두 외부 공기(2)로 마킹."""
    visited = [[False]*M for _ in range(N)]
    q = deque([(0,0)])
    visited[0][0] = True

    while q:
        y, x = q.popleft()
        for dy, dx in dirs:
            ny, nx = y+dy, x+dx
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and cheese[ny][nx] != 1:
                visited[ny][nx] = True
                # 아직 빈(0)이면 외부 공기(2)로 바꾼다
                if cheese[ny][nx] == 0:
                    cheese[ny][nx] = 2
                q.append((ny, nx))

time = 0
while cheeseQueue:
    time += 1

    # 2. 매 턴마다 외부 공기 마킹
    mark_external_air()

    # 3. 녹일 치즈 판별
    melt_list = []
    next_queue = deque()
    for _ in range(len(cheeseQueue)):
        y, x = cheeseQueue.popleft()
        # 인접 외부 공기 개수
        cnt = sum(1 for dy,dx in dirs if cheese[y+dy][x+dx] == 2)
        if cnt >= 2:
            melt_list.append((y, x))
        else:
            next_queue.append((y, x))

    # 4. 치즈 녹이기: 0으로 바꾸면 다음 턴에 mark_external_air()가 2로 마킹
    for y, x in melt_list:
        cheese[y][x] = 0

    cheeseQueue = next_queue

print(time)