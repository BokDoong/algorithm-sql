def solution(board, skill):
    # 가로, 세로
    R, C = len(board), len(board[0])
    
    # 누적합 테이블
    delta = [[0]*(C+1) for _ in range(R+1)]
    for op, rmin, cmin, rmax, cmax, degree in skill:
        # Degree 계산
        if op == 1:
            degree = -degree
        # 누적합 갱신
        delta[rmin][cmin] += degree
        delta[rmin][cmax+1] -= degree
        delta[rmax+1][cmin] -= degree
        delta[rmax+1][cmax+1] += degree
        
    # 누적합 가로/세로 계산
    for r in range(R):
        for c in range(1,C):
            delta[r][c] += delta[r][c-1]
    for c in range(C):
        for r in range(1,R):
            delta[r][c] += delta[r-1][c]
            
    # 결과
    answer = 0
    for r in range(R):
        for c in range(C):
            if board[r][c]+delta[r][c] > 0:
                answer+=1
    return answer