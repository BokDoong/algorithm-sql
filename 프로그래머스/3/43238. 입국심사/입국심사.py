def solution(n, times):
    answer = 0
    
    # 최소, 최대값
    left = min(times)
    right = n * max(times)
    
    # 이분 탐색
    while left <= right:
        people = 0      # 심사한 사람 수
        mid = (left+right) // 2
        for time in times:
            people += mid // time
            if people >= n:
                break
    
        if people >= n:
            right = mid-1
            answer = mid
        else:
            left = mid+1
    
    return answer