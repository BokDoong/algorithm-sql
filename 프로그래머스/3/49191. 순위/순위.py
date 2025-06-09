from collections import deque

def solution(n, results):
    
    ranks = [[0] * n for _ in range(n)]
    
    for win, lose in results:
        ranks[win-1][lose-1] = 1
        ranks[lose-1][win-1] = -1
        
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                if ranks[i][k] == 1 and ranks[k][j] == 1:
                    ranks[i][j] = 1
                    ranks[j][i] = -1
                    
    answer = 0
    for per in ranks:
        if per.count(0) == 1:
            answer += 1
            
    return answer