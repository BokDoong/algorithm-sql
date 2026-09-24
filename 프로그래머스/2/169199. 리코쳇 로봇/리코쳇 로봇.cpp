#include <bits/stdc++.h>

using namespace std;

// 방향

// 큐 : (x, y, 이동거리)

// 4 방향 : 못가면 pass
// 쭉이동
// - 도착하면 끝
// - 이미 값이 있다면 패스 
// - 큐에 넣기

bool canGo(vector<string>& board, int h, int w, int x, int y) {
    return (0 <= x && 0 <= y && x < h && y < w && board[x][y] != 'D');
}

int solution(vector<string> board) {
    
    int h = board.size();
    int w = board[0].size();
    
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    
    queue<tuple<int, int, int>> queue;
    vector<vector<bool>> visited(h, vector<bool>(w, false));
    
    // 도착지
    int targetX = -1; int targetY = -1;
    for (int x = 0; x < h; x++) {
        for (int y = 0; y < w; y++) {
            if (board[x][y] == 'G') { targetX = x; targetY = y; }
            if (board[x][y] == 'R') { queue.push({x, y, 0}); visited[x][y] = true; }
        }
    }
    
    // 4 방향 : 못가면 pass
    // 쭉이동
    // - 도착하면 끝
    // - 큐에 넣기
    while (!queue.empty()) {
        auto [cx, cy, dist] = queue.front();
        queue.pop();
        
        for (int i = 0; i < 4; i++) {    
            int nodeX = cx;
            int nodeY = cy;
            
            // 쭉 이동
            while (canGo(board, h, w, nodeX + dx[i], nodeY + dy[i])) {
                nodeX = nodeX + dx[i];
                nodeY = nodeY + dy[i];
            }
            
            // 도착하면 끝
            if (nodeX == targetX && nodeY == targetY) return dist+1;
            
            // 이미 방문하면 패스
            if (visited[nodeX][nodeY]) continue;
            visited[nodeX][nodeY] = true;
            
            // 큐에 넣기
            queue.push({nodeX, nodeY, dist + 1});
        }
    }
    
    return -1;
}