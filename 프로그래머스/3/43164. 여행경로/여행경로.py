def solution(tickets):
    
    answer = ['ICN']
    visited = [False] * len(tickets)
    tickets.sort(key = lambda x : (x[0], x[1]))
    
    def DFS(airport, path):
        if len(path) == len(tickets) + 1:
            answer.append(path)
            return
        for idx, ticket in enumerate(tickets):
            if ticket[0] == airport and not visited[idx]:
                visited[idx] = True
                DFS(ticket[1], path+[ticket[1]])
                visited[idx] = False
                
    DFS("ICN", ["ICN"])
    return answer[1]