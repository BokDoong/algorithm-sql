def solution(distance, rocks, n):
    answer = 0
    
    rocks.append(distance)
    rocks = sorted(rocks)
    
    left, right = 0, distance
    while left <= right:
        mid = (left+right) // 2
        minDist = float('inf')
        current = 0
        removeCnt = 0
        
        for rock in rocks:
            diff = rock - current
            if diff < mid:
                removeCnt += 1
            else:
                current = rock
                minDist = min(minDist, diff)
                
        if removeCnt > n:
            right = mid - 1
        else:
            answer = minDist
            left = mid + 1
        
    return answer