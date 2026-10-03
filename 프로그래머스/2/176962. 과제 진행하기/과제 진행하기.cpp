#include <bits/stdc++.h>

using namespace std;

// ["english", "12:10", "20"]
// 시작 시간 기준 정렬 : (시작시간, 과목, 소요시간)
vector<tuple<int, string, int>> sorting(vector<vector<string>>& plans) {
    vector<tuple<int, string, int>> result;
    for (int i = 0; i < plans.size(); i++) {
        string subject = plans[i][0];
        string startTime = plans[i][1];
        string duration = plans[i][2];
        result.push_back({stoi(startTime.substr(0, 2))*60 + stoi(startTime.substr(3, 2)), subject, stoi(duration)});
    }
    sort(result.begin(), result.end());
    return result;
}

// 스택 : {과목명, 남은시간}
// 리스트 : (시작시간, 과목, 소요시간)

vector<string> solution(vector<vector<string>> plans) {
    vector<tuple<int, string, int>> sortedPlans = sorting(plans);
    stack<pair<string, int>> remains;
    vector<string> result;
    
    // 하나씩 순회
    // - startTime: 지금 작업 시작시간
    // - dur: 다음까지 얼마나 있는지 체크 
    for (int i = 0; i < sortedPlans.size(); i++) {
        auto [startTime, subject, playTime] = sortedPlans[i];
        
        // - 마지막이면 
        //   - 결과에 넣고 끝
        if (i == sortedPlans.size() - 1) {
            result.push_back(subject);
            break;
        }
        
        // - 지금 PlayTime 빼기
        auto [nextStartTime, nextSubject, nextPlayTime] = sortedPlans[i+1];
        int duration = nextStartTime - startTime;
        //   - dur < playTime: 차이 만큼 스택에 넣기
        if (duration < playTime) {
            remains.push({subject, playTime - duration});
        } 
        //   - dur == playTime: 결과에 넣고 다음
        else if (duration == playTime) {
            result.push_back(subject);
        }
        //   - dur > playTime
        //     - 결과에 넣기, 스택에 없으면 다음
        //     - 스택에 있는 애들 하나씩 빼서 dur이 0이 될 때까지 뺴기
        else {
            result.push_back(subject);
            duration -= playTime;
            while (!remains.empty()) {
                auto [remainSubject, remainDuration] = remains.top();
                remains.pop();
                if (remainDuration > duration) {
                    remains.push({remainSubject, remainDuration - duration});
                    break;
                }
                else if (remainDuration == duration) {
                    result.push_back(remainSubject);
                    break;
                }
                else {
                    result.push_back(remainSubject);
                    duration -= remainDuration;
                }
            }
        }   
    }
    
    // - stack에 있다면 다 빼기
    while (!remains.empty()) {
        auto [remainSubject, remainDuration] = remains.top();
        remains.pop();
        result.push_back(remainSubject);
    }
    
    return result;
}