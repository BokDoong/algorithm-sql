def count_h(mid, citations):
    for i in range(len(citations)):
        if citations[i] >= mid:
            return len(citations) - i
    return 0

def solution(citations):
    citations.sort()
    left, right = 0, max(citations)
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        h_count = count_h(mid, citations)

        if h_count >= mid:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1
    return answer