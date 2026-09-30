#include <bits/stdc++.h>

using namespace std;

// plans > todoPlans(과목, 요청시간 - 분, 수행시간 - 분)
// 요청시간 기준으로 정렬
vector<tuple<string, int, int>> todoPlans;
void initialize(vector<vector<string>>& plans) {
    for (int i = 0; i < plans.size(); i++) {
        string subject = plans[i][0];
        int startTime =  stoi(plans[i][1].substr(0, 2))*60 + stoi(plans[i][1].substr(3, 2));
        int ingTime = stoi(plans[i][2]);
        todoPlans.push_back({subject, startTime, ingTime});
    }
    
    sort(todoPlans.begin(), todoPlans.end(), [](const tuple<string, int, int>& a, const tuple<string, int, int>& b) {
        return get<1>(a) < get<1>(b);
    });
}

// 현재 작업이 끝나는 시간 vs 다음 작업 시작시간
// - 현재 작업 끝나는 시간이 빠르다면 : answer에 추가. time = 현재 작업 끝나는 시간
// - 다음 작업 시작시간이 빠르다면 : stack에 추가. time = 다음 작업 시간 시간 

// time = 다음 작업 시간
// idx++
vector<string> answer;
void solve(vector<vector<string>>& plans) {
    
    stack<pair<string, int>> pauses;
    int n = todoPlans.size();
    
    for (int i = 0; i < n; i++) {
        auto [subject, startTime, ingTime] = todoPlans[i];
        
        // 마지막 과제는 무조건끝
        if (i == n-1) {
            answer.push_back(subject);
            break;
        }
        
        // 이 구간에서 쓸 수 있는 시간
        int nextStart = get<1>(todoPlans[i+1]);
        int avail = nextStart - startTime;
        
        // 이 구간안에 끝날 수 있음.
        if (ingTime <= avail) {
            answer.push_back(subject);
            avail -= ingTime;
            // 남은 시간동안 쌓였던 것 하기
            while (avail > 0 && !pauses.empty()) {
                auto& [s, rem] = pauses.top();
                if (rem <= avail) {
                    avail -= rem;
                    answer.push_back(s);
                    pauses.pop();
                } else {
                    rem -= avail;
                    avail = 0;
                }
            }
        } 
        // 못끊내면 할 만큼 하고 스택에 넣기
        else {
            pauses.push({subject, ingTime - avail});
        }
    }
    
    while (!pauses.empty()) {
        answer.push_back(pauses.top().first);
        pauses.pop();
    }
}

// 스택에 여전히 남아있다면 하나씩 빼서 answer에 넣기 

// plans: (과목, 요청시간, 수행시간)
// result: 수행 완료한 과목들
vector<string> solution(vector<vector<string>> plans) {
    todoPlans.clear();
    initialize(plans);
    
    answer.clear();
    solve(plans);
    
    return answer;
}