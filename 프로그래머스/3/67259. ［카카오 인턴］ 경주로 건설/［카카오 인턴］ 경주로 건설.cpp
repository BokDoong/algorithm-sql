#include <bits/stdc++.h>

using namespace std;

// 큐 : (x, y, 이동 방향)
// 이동 방향 : 0 - 상, 1 - 우, 2 - 하, 3 - 좌

// 시작 - (0, 0, 1), (0, 0, 2)

// 이동
// - 1이거나, 나갔으면 pass
// - 방향 기준으로 다음값 계산 > 다음 노드 비용이 0이거나 더 크다면 갱신하고 큐에 넣기

bool canGo(vector<vector<int>> board, int x, int y) {
    return 0 <= x && x < board.size() && 0 <= y && y < board[0].size() && board[x][y] != 1;
}

// 이동 방향 : 0 - 상, 1 - 우, 2 - 하, 3 - 좌
bool isCorner(int vector, int i) {
    if (vector == 0 || vector == 2) {
        return i == 1 || i == 3;
    } else if (vector == 1 || vector == 3) {
        return i == 0 || i == 2;
    } 
    return false;
}

int solution(vector<vector<int>> board) {
    
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    
    int n = board.size();
    vector<vector<vector<int>>> dist(n, vector<vector<int>>(n, vector<int>(4, INT_MAX)));
    dist[0][0][1] = dist[0][0][2] = 0;
    
    queue<tuple<int, int, int, int>> queue;
    queue.push({0, 0, 0, 1});
    queue.push({0, 0, 0, 2});
    
    while(!queue.empty()) {
        auto [nx, ny, cost, vector] = queue.front();
        queue.pop();
        
        for (int i = 0; i < 4; i++) {
            int nextX = nx + dx[i];
            int nextY = ny + dy[i];
            
            if (!canGo(board, nextX, nextY)) continue;
            
            int nextDist = cost;
            if (isCorner(vector, i)) nextDist += 600;
            else nextDist += 100;
            
            if (dist[nextX][nextY][i] > nextDist) {
                dist[nextX][nextY][i] = nextDist;
                queue.push({nextX, nextY, nextDist, i});
            }
        }
    }
    
    return min({dist[n-1][n-1][0], dist[n-1][n-1][1], dist[n-1][n-1][2], dist[n-1][n-1][3]});
}