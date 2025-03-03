import sys
from collections import defaultdict

input = sys.stdin.readline

# 이동 함수
def move(nextX, nextY, moveHorses):
    global info, horses, time
    
    # 이동한 위치에 말 추가
    info[(nextX, nextY)].extend(moveHorses)
    
    # 말 위치 갱신
    for horse in moveHorses:
        x, y, di = horses[horse]
        horses[horse] = (nextX, nextY, di)

    # 말이 4개 이상 쌓이면 종료
    if len(info[(nextX, nextY)]) >= 4:
        print(time)
        exit()

# 방향 반전 함수
def reverseDi(di):
    return {1: 2, 2: 1, 3: 4, 4: 3}[di]

# 벗어나거나 파란색 체크
def checkOutOrBlue(x, y):
    return x < 0 or y < 0 or x >= N or y >= N or board[x][y] == 2

# 체스판 크기 : N, 말의 개수 : K
N, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

# 위치 정보 저장 (defaultdict 사용)
info = defaultdict(list)
horses = {}

# 말 정보 입력
for k in range(1, K+1):
    x, y, di = map(int, input().split())
    x, y = x - 1, y - 1  # 인덱스 조정
    horses[k] = (x, y, di)
    info[(x, y)].append(k)

# 이동 방향 (우, 좌, 상, 하)
dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]

# 턴 시작
time = 1
while time <= 1000:
    for num in sorted(horses.keys()):  # 번호순 정렬
        x, y, di = horses[num]

        # 현재 위치에서 이동할 말 찾기
        idx = info[(x, y)].index(num)
        moveHorses = info[(x, y)][idx:]
        info[(x, y)] = info[(x, y)][:idx]  # 기존 리스트에서 이동할 말 제거
        
        # 다음 위치
        nextX, nextY = x + dx[di], y + dy[di]

        # 벗어나거나 파란색이면 방향 반전
        if checkOutOrBlue(nextX, nextY):
            di = reverseDi(di)
            horses[num] = (x, y, di)  # 방향 변경 반영
            nextX, nextY = x + dx[di], y + dy[di]  # 반대 방향으로 이동

            # 반대 방향도 벗어나거나 파란색이면 제자리 유지
            if checkOutOrBlue(nextX, nextY):
                move(x, y, moveHorses)  # 원래 자리 유지
                continue

        # 빨간색이면 말 순서 반전
        if board[nextX][nextY] == 1:
            moveHorses.reverse()

        # 이동 실행
        move(nextX, nextY, moveHorses)

    time += 1

# 1000턴 넘어가면 -1 출력
print(-1)