#include <bits/stdc++.h>

using namespace std;
using T = tuple<int, int, int>;

int solution(vector<vector<int>> jobs) {
    int n = jobs.size();
    
    for (int i = 0; i < n; i++) jobs[i].push_back(i);
    sort(jobs.begin(), jobs.end());
    
    priority_queue<T, vector<T>, greater<T>> pq;
    int idx = 0, now = 0, total = 0;
    
    while (idx < n || !pq.empty()) {
        while (idx < n && jobs[idx][0] <= now) {
            pq.push({jobs[idx][1], jobs[idx][0], jobs[idx][2]});
            idx++;
        }
        
        if (pq.empty()) { now = jobs[idx][0]; continue; }
        auto [dur, req, id] = pq.top();
        pq.pop();
        
        now += dur;
        total += now - req;
    }
    
    return total / n;
}