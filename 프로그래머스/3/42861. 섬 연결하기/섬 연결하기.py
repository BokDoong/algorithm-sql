def solution(n, costs):
    # 비용 정렬
    costs.sort(key = lambda x : x[2])
    # 부모, 비용(답), 깊이
    parents = [i for i in range(n)]
    answer = 0
    depth = 1
    
    # 조상 노드 찾기
    def find(node):
        if parents[node] == node:
            return node
        return find(parents[node])
    # 합치기
    def union(nodeA, nodeB):
        parentA, parentB = find(nodeA), find(nodeB)
        parents[parentB] = parentA
    
    # 크루스칼
    while depth < n:
        nodeA, nodeB, cost = costs.pop(0)
        parentA, parentB = find(nodeA), find(nodeB)
        if parentA != parentB:
            union(nodeA, nodeB)
            answer += cost
            depth += 1
        
    return answer