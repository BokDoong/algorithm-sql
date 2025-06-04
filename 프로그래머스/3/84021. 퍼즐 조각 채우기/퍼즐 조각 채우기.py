from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# 보드와 퍼즐에서 빈 공간과 블럭을 찾는 함수
def findBlock(board, f):
    emptyBoardList = []
    visited = [[False] * len(board[0]) for _ in range(len(board))]
    
    for i in range(len(board)):
        for j in range(len(board[i])):
            if not visited[i][j] and board[i][j] == f:
                queue = deque([(i, j)])
                board[i][j] = f ^ 1
                visited[i][j] = True
                lst = [(i, j)]
                
                while queue:
                    x, y = queue.popleft()
                    for _ in range(4):
                        nx, ny = x + dx[_], y + dy[_]
                        if nx < 0 or nx > len(board)-1 or ny < 0 or ny > len(board)-1:
                            continue
                        elif board[nx][ny] == f:
                            queue.append((nx, ny))
                            board[nx][ny] = 1 ^ f
                            visited[nx][ny] = True
                            lst.append((nx, ny))
                emptyBoardList.append(lst)
                
    return emptyBoardList

# Block의 인덱스로 테이블을 만드는 함수
def makeTable(block):
    x, y = zip(*block)
    c, r = max(x) - min(x) + 1, max(y) - min(y) + 1
    table = [[0] * r for _ in range(c)]
    
    for i, j in block:
        i, j = i - min(x), j - min(y)
        table[i][j] = 1
    return table

# 오른쪽으로 90도 회전하는 함수
def rotate(puzzle):
    rotate = [[0] * len(puzzle) for _ in range(len(puzzle[0]))]
    count = 0
    for i in range(len(puzzle)):
        for j in range(len(puzzle[i])):
            if puzzle[i][j] == 1:
                count += 1
            rotate[j][len(puzzle) - 1 - i] = puzzle[i][j]
    return rotate, count

def solution(gameBoard, table):
    answer = 0
    emptyBlocks = findBlock(gameBoard, 0)
    puzzles = findBlock(table, 1)       # 퍼즐과 채워야할 빈 공간 찾기
    
    for empty in emptyBlocks:
        filled = False
        table = makeTable(empty)
        
        for puzzleOrigin in puzzles:
            if filled == True:
                break
            
            puzzle = makeTable(puzzleOrigin)
            for i in range(4):
                puzzle, count = rotate(puzzle)
                if table == puzzle:
                    answer += count
                    puzzles.remove(puzzleOrigin)
                    filled = True
                    break
    
    return answer