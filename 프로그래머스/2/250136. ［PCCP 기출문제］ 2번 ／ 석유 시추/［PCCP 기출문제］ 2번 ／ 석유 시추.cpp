#include <bits/stdc++.h>

using namespace std;

// 방문, y열
bool visited[505][505];
int sizes[505];

// 구간 구하기
// - bfs, 너비 계속 더하기, 방문 안했으면 ㄱㄱ
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

bool canGo(int n, int m, int x, int y) {
    if (0 <= x && x < n && 0 <= y && y < m) return true;
    return false;
}

void solve(vector<vector<int>>& land, int n, int m) {     // visited 인자 삭제, void
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (visited[i][j] || land[i][j] == 0) continue;   // 빈 땅에서는 시작 안 함

            int size = 0;
            queue<pair<int, int>> q;
            q.push({i, j});                                // push
            visited[i][j] = true;                          // 시작 칸 방문 표시

            set<int> pathYs;
            while (!q.empty()) {
                auto [x, y] = q.front();
                q.pop();
                pathYs.insert(y);
                size++;

                for (int k = 0; k < 4; k++) {              // 바깥 i와 겹치지 않게 k
                    int nextX = x + dx[k];
                    int nextY = y + dy[k];
                    if (!canGo(n, m, nextX, nextY)) continue;
                    if (visited[nextX][nextY]) continue;
                    if (land[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        q.push({nextX, nextY});            // push
                    }
                }
            }
            for (int pathY : pathYs) sizes[pathY] += size; // 지나간 열마다 덩어리 크기 더하기
        }
    }
}

int solution(vector<vector<int>> land) {
    int n = land.size();
    int m = land[0].size();
    memset(visited, 0, sizeof visited);                    // 리셋
    memset(sizes, 0, sizeof sizes);

    solve(land, n, m);

    int answer = 0;
    for (int j = 0; j < m; j++) answer = max(answer, sizes[j]);
    return answer;
}