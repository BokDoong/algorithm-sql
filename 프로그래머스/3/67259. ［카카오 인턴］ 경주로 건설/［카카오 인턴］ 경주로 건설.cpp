#include <bits/stdc++.h>

using namespace std;

bool canGo(vector<vector<int>>& board, int h, int w, int x, int y) {
    if (0 <= x && x < h && 0 <= y && y < w && board[x][y] != 1) return true;
    else return false;
}

// 아래 : 0, 오른쪽 : 1, 위 : 2, 왼쪽 : 3
bool isCorner(int nowV, int nextV) {
    if (nowV == 0 || nowV == 2) {
        return nextV == 1 || nextV == 3;
    }
    if (nowV == 1 || nowV == 3) {
        return nextV == 0 || nextV == 2;
    }
}

int solution(vector<vector<int>> board) {
    
    int h = board.size();
    int w = board[0].size();
    
    int dist[h][w][4];
    dist[0][0][0] = 0; dist[0][0][1] = 0;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            for (int k = 0; k < 4; k++) {
                dist[i][j][k] = INT_MAX;
            }
        }
    }

    queue<tuple<int, int, int, int>> queue;
    queue.push({0, 0, 0, 0});
    queue.push({0, 0, 1, 0});
    
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    
    while (!queue.empty()) {
        
        auto [x, y, v, d] = queue.front();
        queue.pop();
        
        if (x == h-1 && y == w-1) continue;
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (!canGo(board, h, w, nextX, nextY)) continue;
            
            int nextD = d;
            if (isCorner(v, i)) nextD += 600;
            else nextD += 100;
            
            if (dist[nextX][nextY][i] > nextD) {
                dist[nextX][nextY][i] = nextD;
                queue.push({nextX, nextY, i, nextD});
            }
        }
        
    }
    
    int answer = INT_MAX;
    for (int i = 0; i < 4; i++) {
        answer = min(answer, dist[h-1][w-1][i]);
    }
    return answer;
}