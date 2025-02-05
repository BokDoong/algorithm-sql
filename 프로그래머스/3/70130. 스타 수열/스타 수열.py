from collections import Counter

def solution(a):

    elements = Counter(a)
    answer = -1

    # {x[0], x[1]}, {x[2], x[3]}, ..., {x[2n-2], x[2n-1]} 교집합의 원소의 개수가 1 이상
    # 위의 조건으로 인해서 결국 같은 원소가 몇개 있느냐가 스타수열 길이에 영향을 미침
    # 같은 원소개 n개면 스타수열의 실제 길이는 2n이 되는 것
    for key in elements.keys():

        if elements[key] <= answer:
            continue
        index = 0
        count = 0

        while index < len(a) - 1:
            if (a[index] != key) and (a[index + 1] != key):#교집합이 생기지 않음
                index += 1
                continue
            # x[0] != x[1], x[2] != x[3], ..., x[2n-2] != x[2n-1]
            if (a[index] == a[index + 1]):#조건에 위배됨
                index += 1
                continue
            #위의 2개의 조건은 결국 조건에서 맞지 않으면 방해되는 숫자를 제외시키는 것과 같음
            #조건을 통과했다면 key를 가지고 있는 수타 수열을 만들었다는 것 
            count += 1
            index += 2

        answer = max(answer,count)


    if answer == -1:
        return 0
    else:
        return answer * 2