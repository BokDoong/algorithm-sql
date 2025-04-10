def solution(brown, yellow):
    total = (brown+4)//2
    for m in range(3,total):
        if (m-2)*(total-m-2) == yellow:
            answer = [max(m, total-m), min(m, total-m)]
            break
    return answer