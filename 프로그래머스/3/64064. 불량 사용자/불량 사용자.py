import sys
input = sys.stdin.readline

import re
from itertools import permutations

def solution(user_id, banned_id):
    answer = 0
    # 정규표현식 위해 "*" -> "."
    banned_id = [i.replace("*", ".") for i in banned_id]

    result = list()
    for i in permutations(user_id, len(banned_id)):
        i = list(i)
        
        check = True
        for j in range(len(i)):
            if (re.match(banned_id[j], i[j]) and (len(i[j]) == len(banned_id[j]))):
                continue
            else:
                check=False
                break
                
        if check:
            if sorted(i) not in result:
                result.append(sorted(i))
    
    print(result)
    answer = len(result)
    return answer