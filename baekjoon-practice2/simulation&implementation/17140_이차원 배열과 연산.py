import sys
input = sys.stdin.readline

# 0이 아닌 숫자만 필터링
def findNotZeroNums(nums):
    return [num for num in nums if num > 0]

# 특정 위치 (r-1, c-1)에 원하는 값이 있는지 확인
def check():
    global board, r, c, k
    return board[r-1][c-1] == k

# 숫자 개수별 정렬
def calculate(nums):
    counts = {}
    for num in set(nums):
        counts[num] = nums.count(num)

    # (등장 횟수, 숫자 값 순)으로 정렬
    counts = sorted(counts.items(), key=lambda x: (x[1], x[0]))

    # 결과 배열 (최대 길이 100 유지)
    result = []
    for num, count in counts:
        result += [num, count]
    return result[:100]  # 최대 100개까지만 유지

# 입력 처리
r, c, k = map(int, input().split())

# 100×100 배열로 초기화
board = [[0]*100 for _ in range(100)]
for i in range(3):
    tmp = list(map(int, input().split()))
    for j in range(3):
        board[i][j] = tmp[j]

# 최대 행, 열 크기
maxX, maxY = 3, 3

# 목표값이 처음부터 있는 경우
if check():
    print(0)
    exit()

# 연산 수행
for t in range(1, 101):
    if maxX >= maxY:  # R 연산 (행 기준 정렬)
        tmpMaxY = 0
        for x in range(maxX):
            nums = findNotZeroNums(board[x])  # 0이 아닌 숫자 찾기
            sortedNums = calculate(nums)      # 개수 기준 정렬

            for i in range(100):  # 기존 값을 0으로 초기화
                board[x][i] = 0

            for i in range(len(sortedNums)):  # 새로운 값 배치
                board[x][i] = sortedNums[i]

            tmpMaxY = max(tmpMaxY, len(sortedNums))  # 최대 열 개수 갱신

        maxY = min(tmpMaxY, 100)  # 최대 100 제한

    else:  # C 연산 (열 기준 정렬)
        tmpMaxX = 0
        for y in range(maxY):
            nums = [board[x][y] for x in range(maxX) if board[x][y] > 0]  # 세로 숫자 모으기
            sortedNums = calculate(nums)  # 개수 기준 정렬

            for i in range(100):  # 기존 값을 0으로 초기화
                board[i][y] = 0

            for i in range(len(sortedNums)):  # 새로운 값 배치
                board[i][y] = sortedNums[i]

            tmpMaxX = max(tmpMaxX, len(sortedNums))  # 최대 행 개수 갱신

        maxX = min(tmpMaxX, 100)  # 최대 100 제한

    # 목표값이 있는지 확인
    if check():
        print(t)
        exit()

print(-1)