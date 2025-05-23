def solution(money):
    # 첫 집을 무조건 터는 경우 -> 맨 마지막은 털지 못한다.
    DP1 = [0] * len(money)
    DP1[0] = money[0]
    DP1[1] = max(money[0], money[1])
    
    for i in range(2, len(money)-1):
        DP1[i] = max(DP1[i-1], DP1[i-2]+money[i])
        
    # 마지막 집을 무조건 터는 경우 -> 첫 집은 털지 못한다.
    DP2 = [0] * len(money)
    DP2[1] = money[1]
    
    for i in range(2, len(money)):
        DP2[i] = max(DP2[i-1], DP2[i-2]+money[i])
    
    return max(max(DP1), max(DP2))
        