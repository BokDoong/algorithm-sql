from collections import deque
import sys
input = sys.stdin.readline

# 회전
def rotate(x, d, k):
    global circles
    tmp = 1
    while x * tmp <= N:
        if d == 0:    
            circles[x * tmp].rotate(k)  # 시계 방향
        else:         
            circles[x * tmp].rotate(-k)  # 반시계 방향
        tmp += 1 

# 인접한 숫자가 일치하는지 검사
def check():
    sameNumPos = set()
    for i in range(1, N+1):
        for j in range(M):
            # 0이면 건너뛰기
            if circles[i][j] == 0:
                continue

            # 같은 원 내에서 비교 (원형 구조 반영)
            left, right = (j - 1) % M, (j + 1) % M
            if circles[i][j] == circles[i][left]:
                sameNumPos.add((i, j))
                sameNumPos.add((i, left))
            if circles[i][j] == circles[i][right]:
                sameNumPos.add((i, j))
                sameNumPos.add((i, right))

            # 인접한 원판 간 비교
            if i > 1 and circles[i][j] == circles[i-1][j]:
                sameNumPos.add((i, j))
                sameNumPos.add((i-1, j))
            if i < N and circles[i][j] == circles[i+1][j]:
                sameNumPos.add((i, j))
                sameNumPos.add((i+1, j))

    return sameNumPos

# 원판 개수 N, 각 원판에 적힌 숫자 개수 M, 회전 수 T
N, M, T = map(int, input().split())

# 원판 데이터
circles = [deque([0]*M)]
for _ in range(N):
    circles.append(deque(map(int, input().split())))

# 회전 정보
rotateInfo = [tuple(map(int, input().split())) for _ in range(T)]

for x, d, k in rotateInfo:
    rotate(x, d, k)   # 회전
    pos = check()     # 인접한 숫자 찾기

    if pos:  # 인접한 숫자가 있으면 제거
        for posX, posY in pos:
            circles[posX][posY] = 0
    else:  # 없으면 평균 계산
        total = sum(sum(circles[i]) for i in range(1, N+1))
        size = sum(1 for i in range(1, N+1) for j in range(M) if circles[i][j] > 0)

        if size > 0:
            avg = total / size
            for i in range(1, N+1):
                for j in range(M):
                    if circles[i][j] > 0:
                        if circles[i][j] > avg:
                            circles[i][j] -= 1
                        elif circles[i][j] < avg:
                            circles[i][j] += 1

# 최종 합 출력
print(sum(sum(circles[i]) for i in range(1, N+1)))