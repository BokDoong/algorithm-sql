def solution(numbers):
    
    # 이미 체크했는지 확인
    def alreadyChecked(num):
        nonlocal checked
        if int(num) in checked:
            return True
        else:
            return False
    
    # 소수인지 체크
    def isPrime(num):
        num = int(num)
        if num == 1 or num == 0:
            return False
        for n in range(2, int(num**0.5)+1):
            if num%n == 0:
                return False
        return True
    
    # 답, 방문 배열
    answer = 0
    visited = [False]*len(numbers)
    checked = set()
    
    # 찾기
    def find(target):
        nonlocal visited, answer, numbers
        
        # 탐색
        for i in range(len(numbers)):
            if visited[i]:
                continue
                
            visited[i] = True
            before = target
            target += numbers[i]
            if not alreadyChecked(target) and isPrime(target):
                checked.add(int(target))
                answer += 1
            find(target)
            target = before
            visited[i] = False
        
    find('')
    return answer