def solution(n, costs):
    # 비용순 정렬
    costs.sort(key = lambda x : x[2])
    # 비용, 깊이, 부모테이블
    answer = 0
    depth = 0
    parents = [i for i in range(n)]
    
    # 조상 찾기
    def find(node):
        if parents[node] == node:
            return node
        return find(parents[node])
    
    # 합치기
    def union(nodeA, nodeB):
        parentA = find(nodeA)
        parentB = find(nodeB)
        parents[parentB] = parentA
        
    # 크루스칼
    while depth < n-1:
        nodeA, nodeB, cost = costs.pop(0)
        if find(nodeA) != find(nodeB):
            union(nodeA, nodeB)
            answer += cost
            depth += 1
        
    
    return answer