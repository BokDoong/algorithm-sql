#include <bits/stdc++.h>

using namespace std;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

bool isOut(int x, int y) {
    if (x < 0 || x >= 5 || y < 0 || y >= 5) return true;          // && → ||
    return false;
}

// true : 거리두기 지키고 있음. false : 안지키고 있음.
bool check(int x, int y, vector<string>& place, int dist, int sx, int sy) {
    if (dist == 2) {
        return true;
    }
    for (int i = 0; i < 4; i++) {
        int nextX = x + dx[i];
        int nextY = y + dy[i];
        if (isOut(nextX, nextY)) continue;
        if (nextX == sx && nextY == sy) continue;
        if (place[nextX][nextY] == 'X') continue;
        else if (place[nextX][nextY] == 'P') return false;
        if (!check(nextX, nextY, place, dist+1, sx, sy)) return false;
    }
    return true;
}

// true : 거리두기 지키고 있음. false : 안지키고 있음.
int solve(vector<string>& place) {
    
    // p 좌표 찾아서 > 리스트에 넣기
    vector<pair<int, int>> p;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (place[i][j] == 'P') {
                p.push_back({i, j});
            }
        }
    }
    
    // 비어있으면 끝
    if (p.size() == 0) {
        return 1;
    }
    
    // 하나씩 거리 2까지 P 있는지 보기, X이면 더 안가도됨.
    for (int i = 0; i < p.size(); i++) {
        auto [x, y] = p[i];
        if (!check(x, y, place, 0, x, y)) return 0;
    }
    return 1;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    for (int i = 0; i < 5; i++) {
        answer.push_back(solve(places[i]));
    }
    return answer;
}