import sys

def solution(m, n, puddles):
    # DP
    DP = [[0]*(m+1) for _ in range(n+1)]
    DP[1][1] = 1
    for y, x in puddles:
        DP[x][y] = -1
    
    # 탐색
    for x in range(1, n+1):
        for y in range(1, m+1):
            if DP[x][y] != -1:
                if DP[x-1][y] != -1:
                    DP[x][y] += (DP[x-1][y])%1000000007
                if DP[x][y-1] != -1:
                    DP[x][y] += (DP[x][y-1])%1000000007
    
    print(DP)
    return (DP[n][m])%1000000007