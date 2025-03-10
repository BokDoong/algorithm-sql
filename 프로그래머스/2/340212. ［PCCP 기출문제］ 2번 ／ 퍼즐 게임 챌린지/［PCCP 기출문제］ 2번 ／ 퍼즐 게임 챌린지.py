def solution(diffs, times, limit):
    # 푸는 시간 계산
    def calculate(level):
        nonlocal diffs, times
        result = 0
        for i in range(len(diffs)):
            diff, time = diffs[i], times[i]
            result += time
            if diff > level:
                result += (diff-level)*(time+times[i-1])
        return result
    
    # 이진 탐색
    start, end = 1, max(diffs)
    answer = max(diffs)
    while start < end:
        mid = int((start+end)/2)
        time = calculate(mid)
        if time <= limit:
            end = mid
            answer = mid
        else:
            start = mid+1
            
    return answer