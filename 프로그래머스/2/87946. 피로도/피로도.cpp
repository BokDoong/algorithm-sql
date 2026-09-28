#include <bits/stdc++.h>

using namespace std;

int answer;
bool visited[10];

void backTracking(vector<vector<int>>& dungeons, int visitedCount, int nowK) {
    
    if (visitedCount > answer) {
        answer = visitedCount;
    }
    
    for (int i = 0; i < (int)dungeons.size(); i++) {
        if (visited[i]) continue;
        if (nowK < dungeons[i][0]) continue;
        
        visited[i] = true;
        backTracking(dungeons, visitedCount+1, nowK - dungeons[i][1]);
        visited[i] = false;
    }
    
}

int solution(int k, vector<vector<int>> dungeons) {
    
    answer = 0;
    memset(visited, 0, sizeof visited);
    backTracking(dungeons, 0, k);
    
    return answer;
}

