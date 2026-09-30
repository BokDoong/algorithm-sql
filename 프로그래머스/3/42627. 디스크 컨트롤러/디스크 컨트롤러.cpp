#include <bits/stdc++.h>

using namespace std;

// 시간 카운팅
// - 기본 : jobs 다음 인덱스의 시간
// - 수행중 : 수행중인 작업 끝나는 시간

int solution(vector<vector<int>> jobs) {
    
    priority_queue<tuple<int,int,int>, vector<tuple<int,int,int>>, greater<tuple<int,int,int>>> todo;
    
    // - jobs 정렬
    sort(jobs.begin(), jobs.end());
    int n = jobs.size();
    
    // - job별 수행시간
    vector<int> timePerJob(n);

    // - time 처음으로 점프
    int time = jobs[0][0];
    int idx = 0;
    
    // - jobs 다 수행 할 때까지
    while (idx < n || !todo.empty()) {
        // - 지금 시간 이하에 있는 애들만큼 todo에 넣기
        while (idx < n && jobs[idx][0] <= time) {
            todo.push({jobs[idx][1], jobs[idx][0], idx});
            idx++;
        }
        
        // - todo에 있으면 수행 + time 점프, 없으면 time 다음 job 시간으로
        // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순서
        if (!todo.empty()) {
            auto [doTime, requestTime, requestIdx] = todo.top();
            todo.pop();
            time += doTime;
            timePerJob[requestIdx] = time - requestTime;
        } else {
            time = jobs[idx][0];
        }
    }
    
    int sum = 0;
    for (int i = 0; i < n; i++) sum += timePerJob[i];
    return sum/n;
}