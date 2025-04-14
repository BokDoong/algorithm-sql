def solution(word):
    def DFS(target):
        nonlocal orders
        if len(target) == 5:
            return
        for word in range(1,6):
            target += str(word)
            orders.append(target)
            DFS(target)
            target = target[:len(target)-1]
    
    # DFS
    orders = []
    DFS('')
    
    # 알파벳 순서
    alphabets = {'A':1, 'E':2, 'I':3, 'O':4, 'U':5}
    target = ''
    for w in word:
        target += str(alphabets[w])
    
    return orders.index(target)+1