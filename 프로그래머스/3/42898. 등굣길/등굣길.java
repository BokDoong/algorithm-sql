class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] board = new int[n+1][m+1];
        board[1][1] = 1;
        
        // 웅덩이
        boolean[][] isPuddle = new boolean[n+1][m+1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
            board[puddle[1]][puddle[0]] = 0;
        }
        
        // 하나씩
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (i == 1 && j == 1) continue;
                if (isPuddle[i][j]) continue;
                board[i][j] = (board[i-1][j] + board[i][j-1]) % 1_000_000_007;
            }
        }
        
        return board[n][m] % 1000000007;
    }
}