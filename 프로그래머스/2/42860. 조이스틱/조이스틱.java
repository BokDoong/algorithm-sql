class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 각 자리마다 이동해야 하는 갯수
        for (char c : name.toCharArray()) {
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 이동 방향 선정
        // 1 : 오른쪽 쭉 이동
        int move = n - 1;
        
        // 모든 꺽는 후보
        for (int i = 0; i < n; i++) {
            // A 연속으로 오는 지점 
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            // 오른쪽 i까지 -> 돌아와서 -> 역순 next까지
            move = Math.min(move, i + i + (n - next));
            
            // next로 역순 -> 다시 돌아와서 i까지
            move = Math.min(move, (n - next) + (n - next) + i);
        }
        
        answer += move;
        return answer;
    }
}