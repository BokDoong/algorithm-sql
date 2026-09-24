#include <bits/stdc++.h>

using namespace std;

bool canGo(vector<string>& board, int h, int w, int x, int y) {
    return 0 <= x && x < h && 0 <= y && y < w && board[x][y] != 'D';
}

int solution(vector<string> board) {
    
    int h = board.size();
    int w = board[0].size();
    
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    
    queue<tuple<int, int, int>> queue;
    vector<vector<bool>> visited(h, vector<bool>(w, false));
    
    int targetX = -1;
    int targetY = -1;
    for (int x = 0; x < h; x++) {
        for (int y = 0; y < w; y++) {
            if (board[x][y] == 'G') { targetX = x; targetY = y; }
            if (board[x][y] == 'R') { queue.push({x, y, 0}); visited[x][y] = true; }
        }
    }
    
    while (!queue.empty()) {
        auto [cx, cy, dist] = queue.front();
        queue.pop();
        
        for (int i = 0; i < 4; i++) {
            int nodeX = cx;
            int nodeY = cy;
            
            while (canGo(board, h, w, nodeX + dx[i], nodeY + dy[i])) {
                nodeX += dx[i];
                nodeY += dy[i];
            }
            
            if (nodeX == targetX && nodeY == targetY) return dist + 1;
            
            if (visited[nodeX][nodeY]) continue;
            visited[nodeX][nodeY] = true;
            queue.push({nodeX, nodeY, dist + 1});
        }
    }
    
    return -1;
}