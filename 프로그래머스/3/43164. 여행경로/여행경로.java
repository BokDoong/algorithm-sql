import java.util.*;

class Solution {
    
    Map<String, List<String>> graph = new HashMap<>();
    int maxMoved = 0;
    
    public String[] solution(String[][] tickets) {
        
        // 그래프 완성
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            if (!graph.containsKey(start)) graph.put(start, new ArrayList<>());
            graph.get(start).add(end);
        }
        
        // visited, 
        Map<String, boolean[]> visited = new HashMap<>();
        for (String key : graph.keySet()) {
            maxMoved += graph.get(key).size();
            visited.put(key, new boolean[graph.get(key).size()]);
        }
        
        // 정렬
        for (String key : graph.keySet()) {
            graph.get(key).sort((a, b) -> a.compareTo(b));
        }
        
        // dfs
        List<String> answer = new ArrayList<>();
        answer.add("ICN");
        return dfs("ICN", answer, visited, 0).toArray(new String[0]);
    }
    
    public List<String> dfs(String city, List<String> answer, Map<String, boolean[]> visited, int moved) {
        
        // 다 차있으면 끝
        if (moved == maxMoved) {
            return answer;
        }
            
        // 
        List<String> nodes = graph.get(city);
        if (nodes != null) {
            String nextNode;
            for (int i = 0; i < nodes.size(); i++) {
                if (visited.get(city)[i]) continue;
                visited.get(city)[i] = true;
                nextNode = nodes.get(i);
                answer.add(nextNode);
                List<String> result = dfs(nextNode, answer, visited, moved+1);
                if (result != null) return result;
                visited.get(city)[i] = false;
                answer.removeLast();
            }
        }
        
        return null;
    }
    
}