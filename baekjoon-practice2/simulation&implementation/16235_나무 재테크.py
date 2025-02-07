from collections import deque
import sys
input = sys.stdin.readline

# 겨울 - 양분 추가
def winter():
    for i in range(1, N+1):
        for j in range(1, N+1):
            food[i][j] += additionalFood[i][j]

# 가을 - 주변에 나무 추가
def addNearTrees(x, y):
    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
    
    for i in range(8):
        nx, ny = x + dx[i], y + dy[i]
        if 1 <= nx <= N and 1 <= ny <= N:
            trees[(nx, ny)].appendleft(1)  # 나이가 어린 순으로 정렬 유지

# 입력
N, M, K = map(int, input().split())

# 초기 양분: 기본 5
food = [[5] * (N + 1) for _ in range(N + 1)]

# 추가되는 양분 정보
additionalFood = [[]] + [[0] + list(map(int, input().split())) for _ in range(N)]

# 나무 정보
trees = {(x, y): deque() for x in range(1, N + 1) for y in range(1, N + 1)}

# 나무 입력 (나이가 어린 순으로 추가해야 함)
for _ in range(M):
    x, y, age = map(int, input().split())
    trees[(x, y)].append(age)  # 오름차순 정렬 필요

# K년 동안 반복
for _ in range(K):
    new_trees = []  # 가을에 번식할 나무 저장

    # 봄 & 여름
    for x in range(1, N+1):
        for y in range(1, N+1):
            if not trees[(x, y)]:
                continue

            now_food = food[x][y]
            new_ages = deque()
            dead_food = 0

            for _ in range(len(trees[(x, y)])):
                age = trees[(x, y)].popleft()
                
                if now_food >= age:
                    now_food -= age
                    new_ages.append(age + 1)

                    if (age + 1) % 5 == 0:
                        new_trees.append((x, y))  # 가을 번식을 위해 저장
                else:
                    dead_food += age // 2  # 여름: 죽은 나무는 양분이 됨

            trees[(x, y)] = new_ages
            food[x][y] = now_food + dead_food  # 여름: 죽은 나무의 양분 반영

    # 가을 (저장된 번식 가능한 나무들 처리)
    for x, y in new_trees:
        addNearTrees(x, y)

    # 겨울: 양분 추가
    winter()

# 살아있는 나무 개수 출력
result = sum(len(trees[(x, y)]) for x in range(1, N + 1) for y in range(1, N + 1))
print(result)