from collections import deque
import sys
input = sys.stdin.readline


def spring_summer():
    for i in range(N):
        for j in range(N):
            if tree[i][j]:
                # 매번 정렬 (가을에 appendleft하므로)
                tree[i][j] = deque(sorted(tree[i][j]))
                tree_cnt = len(tree[i][j])
                
                for k in range(tree_cnt):
                    # 봄: 양분 먹기
                    if earth[i][j] >= tree[i][j][k]:
                        earth[i][j] -= tree[i][j][k]
                        tree[i][j][k] += 1
                    # 여름: 양분 부족 시 죽음
                    else:
                        # 현재부터 뒤에 있는 모든 나무 죽음
                        for _ in range(k, tree_cnt):
                            earth[i][j] += tree[i][j].pop() // 2
                        break


def autumn():
    for i in range(N):
        for j in range(N):
            if tree[i][j]:
                for age in tree[i][j]:
                    if age % 5 == 0:
                        for d in range(8):
                            ni, nj = i + dx[d], j + dy[d]
                            if 0 <= ni < N and 0 <= nj < N:
                                tree[ni][nj].appendleft(1)


def winter():
    for i in range(N):
        for j in range(N):
            earth[i][j] += A[i][j]


N, M, K = map(int, input().split())

# 겨울에 추가할 양분
A = [list(map(int, input().split())) for _ in range(N)]

# 3차원 리스트로 나무 관리
tree = [[deque() for _ in range(N)] for _ in range(N)]

# 나무 정보 입력
for _ in range(M):
    x, y, age = map(int, input().split())
    tree[x-1][y-1].append(age)

# 땅 (초기값 5)
earth = [[5] * N for _ in range(N)]

# 8방향
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

# K년 시뮬레이션
for _ in range(K):
    spring_summer()
    autumn()
    winter()

# 살아남은 나무 개수
result = sum(len(tree[i][j]) for i in range(N) for j in range(N))
print(result)
