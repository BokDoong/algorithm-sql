from collections import deque

def countDifferentChar(word1, word2):
    answer = 0
    for i in range(len(word1)):
        if word1[i] != word2[i]:
            answer += 1
    return answer

def solution(begin, target, words):
    # 탐색할 노드
    nodes = []
    for i in range(len(words)):
        nodes.append((i, words[i]))
        
    # 방문 배열
    visited = [False]*len(words)
    # 큐
    queue = deque([(begin, 0)])
    while queue:
        word, depth = queue.popleft()
        if word == target:
            return depth
        for idx, node in nodes:
            cnt = countDifferentChar(word, node)
            if cnt == 1 and not visited[idx]:
                visited[idx] = True
                queue.append((node, depth+1))
    
    return 0