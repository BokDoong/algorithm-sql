def solution(triangle):
    # DP
    DP = []
    for tr in triangle:
        DP.append([0]*len(tr))
    # 탐색
    height = len(triangle)
    DP[0][0] = triangle[0][0]
    for i in range(1, height):
        DP[i][0] = DP[i-1][0] + triangle[i][0]
        DP[i][-1] = DP[i-1][-1] + triangle[i][-1]
        for j in range(1, len(DP[i])-1):
            DP[i][j] = max(DP[i-1][j-1], DP[i-1][j]) + triangle[i][j]
    
    return max(DP[height-1])