def solution(words, queries):
    head, head_rev = {}, {}
    wc = []
    
    # 트리에 저장
    def add(head, word):
        node = head
        for w in word:
            # 없으면 노드 추가
            if w not in node:
                node[w] = {}
            node = node[w]  # 현재 노드 포인터 변경
            
            # 단어 길이 정보 추가
            if 'len' not in node:
                node['len'] = [len(word)]
            else:
                node['len'].append(len(word))
            
        # End
        node['end'] = True
        
    # Main(1)
    for word in words:
        add(head, word)
        add(head_rev, word[::-1])
        wc.append(len(word))
        
    # 탐색
    def search(head, querie):
        count = 0
        node = head
        for q in querie:
            if q == '?':
                return node['len'].count(len(querie))
            elif q not in node:
                break
            node = node[q]
        return count
    
    li = []
    for querie in queries:
        if querie[0] == '?':
            if querie[-1] == '?':
                li.append(wc.count(len(querie)))
            else:
                li.append(search(head_rev, querie[::-1]))
        else:
            li.append(search(head, querie))
            
    return li