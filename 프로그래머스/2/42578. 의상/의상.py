def solution(clothes):
    infos = {}
    for goods, info in clothes:
        if info in infos:
            infos[info].append(goods)
        else:
            infos[info] = [goods]
    
    answer = 1
    for key in infos.keys():
        answer *= len(infos[key])+1
    
    return answer-1