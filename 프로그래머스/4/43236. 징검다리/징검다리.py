def solution(distance, rocks, n):
    # 바위 정렬 + 끝점 넣기
    rocks.sort()
    rocks.append(distance)
    
    # 탐색
    start, end = 0, rocks[-1]
    while start <= end :
        mid = (start+end) // 2
        cntRemove = 0   # 제거한 바위 수
        current = 0
        
        # 제거할 바위 수 세기
        for rock in rocks:
            dist = rock - current
            if dist < mid:
                cntRemove += 1
                if cntRemove > n:
                    break
            else:
                current = rock
                
        if cntRemove > n:
            end = mid-1
        else:
            answer = mid
            start = mid+1
        
    return answer