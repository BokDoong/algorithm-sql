def solution(numbers):
    inputList = list(map(str, numbers))
    
    inputList.sort(key = lambda x:x*3, reverse=True)
    answer = ''
    answer = answer.join(inputList)
    return str(int(answer))