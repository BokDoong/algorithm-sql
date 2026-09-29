#include <bits/stdc++.h>

using namespace std;

vector<vector<pair<int, int>>> paths;

// 로봇마다 가는 지점 기록하기
// 첫끝점 모두 기록해야함
void initializePaths(vector<vector<pair<int, int>>>& paths, vector<vector<int>>& points, vector<vector<int>>& routes) {
    
    for (int i = 0; i < routes.size(); i++) {
        for (int j = 0; j+1 < routes[i].size(); j++) {
            int start = routes[i][j];
            int end = routes[i][j+1];
            start--; end--;

            int startX = points[start][0];
            int startY = points[start][1];
            int endX = points[end][0];
            int endY = points[end][1];

            // 상 > 하
            if (j == 0) paths[i].push_back({startX, startY});
            if (startX < endX) {
                while (startX < endX) {
                    startX++;
                    paths[i].push_back({startX, startY});
                }
            } else if (startX > endX) {
                while (startX > endX) {
                    startX--;
                    paths[i].push_back({startX, startY});
                }
            }

            // 좌 > 우
            if (startY < endY) {
                while (startY < endY) {
                    startY++;
                    paths[i].push_back({startX, startY});
                }
            } else if (startY > endY) {
                while (startY > endY) {
                    startY--;
                    paths[i].push_back({startX, startY});
                }
            }
        }
    }
}

int calculate(vector<vector<pair<int, int>>>& paths) {
    // 가장 긴 배열의 길이 찾아서
    int maxLen = -1;
    for (int i = 0; i < paths.size(); i++) {
        if (maxLen < (int)paths[i].size()) maxLen = paths[i].size();
    }
    
    int answer = 0;
    int t = 0;
    while (t < maxLen) {
        
        // 0 ~ 길이 만큼 하나씩 돌며 집합 두개(진짜 있는곳, 충돌 체킹한 곳)
        set<pair<int, int>> setA;
        set<pair<int, int>> setB;
        
        for (int i = 0; i < paths.size(); i++) {
            if (t >= (int) paths[i].size()) continue;
            auto [x, y] = paths[i][t];
            
            if (setA.count({x, y}) == 0) {
                setA.insert({x, y});
            } else if (setA.count({x, y}) == 1 && setB.count({x, y}) == 0) {
                setB.insert({x, y});
                answer++;
            }
        }
        t++;
    }
    
    return answer;
}

int solution(vector<vector<int>> points, vector<vector<int>> routes) {

    int R = routes.size();
    paths.assign(R, vector<pair<int, int>>());
    
    initializePaths(paths, points, routes);
    
    int answer = calculate(paths);
    return answer;
}