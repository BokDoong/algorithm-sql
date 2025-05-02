def solution(routes):
    answer = 1
    
    # 도착지 기준 정렬
    routes.sort(key = lambda x : x[1])
    # 카메라
    camera = routes[0][1]
    for start, end in routes:
        if start > camera:
            camera = end
            answer += 1
    
    return answer