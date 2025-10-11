from collections import deque

def solution(begin, target, words):
    
    def countDifferenctWords(word1, word2):
        result = 0
        for w in range(len(word1)):
            if word1[w] != word2[w]:
                result+=1
        return result
    
    visited = [False for _ in range(len(words))]
    queue = deque([(begin, 0)])
    
    while queue:
        word, depth = queue.popleft()
        if word == target:
            return depth
        
        for w in range(len(words)):
            if not visited[w]:
                diff = countDifferenctWords(words[w], word)
                if diff == 1:
                    visited[w] = True
                    queue.append((words[w], depth+1))
    
    return 0