import sys

def solution(N, number):
    # N이 number인 경우
    if N == number:
        return 1
    
    # DP 테이블
    DP = [[] for _ in range(9)]
    DP[1].append(N)
    
    # DP
    for target in range(2, 9):
        # 수 연속으로 붙이기
        num = int(str(N)*target)
        if num  == number:
            return target
        else:
            DP[target].append(num)
        # 이전 DP 테이블 원소에서 하나씩 비교
        for i in range(1, target):
            for num1 in DP[i]:
                for num2 in DP[target-i]:
                    # 더하기
                    tmp = num1+num2
                    if tmp == number:
                        return target
                    elif 0 < tmp <= 32000:
                        DP[target].append(tmp)
                    # 빼기
                    tmp = num1-num2
                    if tmp == number:
                        return target
                    elif 0 < tmp <= 32000:
                        DP[target].append(tmp)
                    # 곱하기
                    tmp = num1*num2
                    if tmp == number:
                        return target
                    elif 0 < tmp <= 32000:
                        DP[target].append(tmp)
                    # 나누기
                    tmp = int(num1/num2)
                    if tmp == number:
                        return target
                    elif 0 < tmp <= 32000:
                        DP[target].append(tmp)
    return -1